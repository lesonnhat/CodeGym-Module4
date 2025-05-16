package com.codegym.springbootproductmanagement.controller;

import com.codegym.springbootproductmanagement.model.Product;
import com.codegym.springbootproductmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView listProducts(@RequestParam("search") Optional<String> search, @PageableDefault(value = 2) Pageable pageable) {
        Page<Product> products;
        ModelAndView modelAndView;
        if (search.isPresent()) {
            products = productService.findAllByNameContaining(pageable, search.get());
            modelAndView = new ModelAndView("/product/list");
            modelAndView.addObject("products", products);
            modelAndView.addObject("search", search.get());
        } else {
            products = productService.findAll(pageable);
            modelAndView = new ModelAndView("/product/list");
            modelAndView.addObject("products", products);
        }
        return modelAndView;
    }
}
