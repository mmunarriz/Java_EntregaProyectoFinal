package com.example.entregafinal.service;

import com.example.entregafinal.model.Product;
import com.example.entregafinal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product agregarProduct(Product product) {
        return productRepository.save(product);
    }

    public void eliminarProduct(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto con ID " + id + " no encontrado");
        }
    }
}
