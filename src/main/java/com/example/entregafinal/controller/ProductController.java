package com.example.entregafinal.controller;

import com.example.entregafinal.model.Product;
import com.example.entregafinal.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "Operaciones relacionadas con los productos")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/agregar")
    @Operation(summary="Agregar un nuevo producto", description = "Agrega un nuevo producto al sistema")
    public Product agregarProduct(@RequestBody Product product) {
        return productService.agregarProduct(product);
    }

    @DeleteMapping("/eliminar/{id}")
    @Operation(summary="Eliminar un producto por ID", description="Elimina un producto utilizando su numero de ID")
    public void eliminarProduct(@PathVariable int id) {
        productService.eliminarProduct(id);
    }

}
