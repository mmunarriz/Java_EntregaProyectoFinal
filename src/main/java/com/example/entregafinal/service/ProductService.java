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

    public Optional<Product> buscarProduct(int id) {
        return productRepository.findById(id);
    }

    public void eliminarProduct(int id) {
        productRepository.deleteById(id);
    }

    public Product actualizarProduct(int id, Product product) {
        Optional<Product> productExistente = productRepository.findById(id);

        if (productExistente.isPresent()) {
            Product actual = productExistente.get();
            actual.setName(product.getName());
            actual.setPrice(product.getPrice());
            return productRepository.save(actual);
        } else {
            return null;
        }
    }
}
