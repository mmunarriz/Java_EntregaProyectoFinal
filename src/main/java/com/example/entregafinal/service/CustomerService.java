package com.example.entregafinal.service;

import com.example.entregafinal.model.Customer;
import com.example.entregafinal.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer agregarCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void eliminarCustomer(int id) {
        customerRepository.deleteById(id);
    }

}
