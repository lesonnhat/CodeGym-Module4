package com.shoppingcart.controller;

import com.shoppingcart.model.Cart;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.ProductDescription;
import com.shoppingcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    // Giảm số lượng sản phẩm trong giỏ hàng
    @GetMapping("/reduce/{id}")
    public String reduceFromCart(@PathVariable Long id,
                                 @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        cart.reduceProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }

    // Xóa sản phẩm khỏi giỏ hàng
    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id,
                                 @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        cart.removeProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }

    // Hiển thị form thêm sản phẩm
    @GetMapping("/add-product")
    public ModelAndView showAddProductForm() {
        ModelAndView modelAndView = new ModelAndView("/add-product");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    // Xử lý thêm sản phẩm
    @PostMapping("/add-product")
    public String addProduct(
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("imageUrl") String imageUrl,
            @RequestParam("descriptions") String descriptions) {
        Product product = new Product(name, price, imageUrl);
        String[] descriptionArray = descriptions.split(",\\s*");
        for (String desc : descriptionArray) {
            if (!desc.trim().isEmpty()) {
                product.addDescription(new ProductDescription(desc.trim()));
            }
        }
        productService.save(product);
        return "redirect:/shop";
    }
}