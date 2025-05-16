package com.codegym.springbootproductmanagement.repository;

import com.codegym.springbootproductmanagement.model.Order;
import com.codegym.springbootproductmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
}
