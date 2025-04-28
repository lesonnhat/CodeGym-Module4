package com.thquanlykhtinh.service;

import com.thquanlykhtinh.model.Customer;
import com.thquanlykhtinh.model.Province;

public interface ICustomerService extends IGenerateService<Customer>{
    Iterable<Customer> findAllByProvince(Province province);
}