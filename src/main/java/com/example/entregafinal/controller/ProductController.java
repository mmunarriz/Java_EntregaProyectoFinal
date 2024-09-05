package com.example.entregafinal.controller;

import com.example.entregafinal.model.Product;
import com.example.entregafinal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/agregar")
    public Product agregarProduct(@RequestBody Product product) {
        return productService.agregarProduct(product);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Product> buscarProduct(@PathVariable int id) {
        return productService.buscarProduct(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProduct(@PathVariable int id) {
        productService.eliminarProduct(id);
    }

    @PutMapping("/actualizar/{id}")
    public Product actualizarProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.actualizarProduct(id, product);
    }
}
