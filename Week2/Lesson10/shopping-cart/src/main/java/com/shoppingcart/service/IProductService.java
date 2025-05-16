package com.shoppingcart.service;

import com.shoppingcart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product); // Thêm phương thức lưu sản phẩm
}