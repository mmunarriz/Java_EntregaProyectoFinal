package com.example.entregafinal.repository;

import com.example.entregafinal.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> { }
