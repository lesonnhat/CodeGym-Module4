package com.customermanageaspect.service;

import com.customermanageaspect.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Override
    public List<Customer> findAll() throws Exception {
        return Arrays.asList(
                new Customer(1L, "Nguyen Van A"),
                new Customer(2L, "Tran Thi B")
        );
    }

    @Override
    public Customer findOne(Long id) throws Exception {
        return new Customer(id, "Khach Hang " + id);
    }
}