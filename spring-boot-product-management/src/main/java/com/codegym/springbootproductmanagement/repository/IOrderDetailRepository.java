package com.codegym.springbootproductmanagement.repository;

import com.codegym.springbootproductmanagement.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long>{
}
