package com.example.entregafinal.controller;

import com.example.entregafinal.model.SalesProduct;
import com.example.entregafinal.service.SalesProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sales-products")
public class SalesProductController {

    @Autowired
    private SalesProductService salesProductService;

    @PostMapping("/agregar")
    public SalesProduct agregarSalesProduct(@RequestBody SalesProduct salesProduct) {
        return salesProductService.agregarSalesProduct(salesProduct);
    }

    @GetMapping("/buscar/{id}")
    public Optional<SalesProduct> buscarSalesProduct(@PathVariable int id) {
        return salesProductService.buscarSalesProduct(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarSalesProduct(@PathVariable int id) {
        salesProductService.eliminarSalesProduct(id);
    }

    @PutMapping("/actualizar/{id}")
    public SalesProduct actualizarSalesProduct(@PathVariable int id, @RequestBody SalesProduct salesProduct) {
        return salesProductService.actualizarSalesProduct(id, salesProduct);
    }
}
