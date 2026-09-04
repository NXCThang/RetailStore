package com.rs.retailstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rs.retailstore.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByUsername(String username);
}
