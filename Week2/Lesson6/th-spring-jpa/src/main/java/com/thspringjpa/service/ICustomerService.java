package com.thspringjpa.service;

import com.thspringjpa.model.Customer;

public interface ICustomerService {
    boolean saveWithStoredProcedure(Customer customer);
}