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

    public Optional<Customer> buscarCustomer(int id) {
        return customerRepository.findById(id);
    }

    public void eliminarCustomer(int id) {
        customerRepository.deleteById(id);
    }

    public Customer actualizarCustomer(int id, Customer customer) {
        Optional<Customer> customerExistente = customerRepository.findById(id);

        if (customerExistente.isPresent()) {
            Customer actual = customerExistente.get();
            actual.setName(customer.getName());
            actual.setEmail(customer.getEmail());
            actual.setPhone(customer.getPhone());
            actual.setSales(customer.getSales());
            return customerRepository.save(actual);
        } else {
            return null;
        }
    }
}
