package com.thspringjpa.repository;

import com.thspringjpa.model.Customer;

public interface ICustomerRepository {
    boolean saveWithStoredProcedure(Customer customer);
}