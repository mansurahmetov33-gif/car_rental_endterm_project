package org.carrental.service;

import org.carrental.model.Customer;
import org.carrental.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
}
