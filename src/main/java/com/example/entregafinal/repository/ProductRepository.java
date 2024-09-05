package com.example.entregafinal.repository;

import com.example.entregafinal.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> { }
