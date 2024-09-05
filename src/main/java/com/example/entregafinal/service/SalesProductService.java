package com.example.entregafinal.service;

import com.example.entregafinal.model.SalesProduct;
import com.example.entregafinal.repository.SalesProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalesProductService {

    @Autowired
    private SalesProductRepository salesProductRepository;

    public SalesProduct agregarSalesProduct(SalesProduct salesProduct) {
        return salesProductRepository.save(salesProduct);
    }

    public Optional<SalesProduct> buscarSalesProduct(int id) {
        return salesProductRepository.findById(id);
    }

    public void eliminarSalesProduct(int id) {
        salesProductRepository.deleteById(id);
    }

    public SalesProduct actualizarSalesProduct(int id, SalesProduct salesProduct) {
        Optional<SalesProduct> salesProductExistente = salesProductRepository.findById(id);

        if (salesProductExistente.isPresent()) {
            SalesProduct actual = salesProductExistente.get();
            actual.setSale(salesProduct.getSale());
            actual.setProduct(salesProduct.getProduct());
            actual.setQuantity(salesProduct.getQuantity());
            return salesProductRepository.save(actual);
        } else {
            return null;
        }
    }
}
