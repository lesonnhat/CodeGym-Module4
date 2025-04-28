package com.thquanlykhtinh.repository;

import com.thquanlykhtinh.model.Customer;
import com.thquanlykhtinh.model.Province;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}