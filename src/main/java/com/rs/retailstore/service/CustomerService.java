package com.rs.retailstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rs.retailstore.model.Customer;
import com.rs.retailstore.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        String password = customer.getPassword();
        customer.setPassword(passwordEncoder.encode(password));
        return customerRepository.save(customer);
    }
}
