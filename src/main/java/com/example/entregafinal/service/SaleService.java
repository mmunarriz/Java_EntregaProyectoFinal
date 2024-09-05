package com.example.entregafinal.service;

import com.example.entregafinal.model.Sale;
import com.example.entregafinal.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public Sale agregarSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Optional<Sale> buscarSale(int id) {
        return saleRepository.findById(id);
    }

    public void eliminarSale(int id) {
        saleRepository.deleteById(id);
    }

    public Sale actualizarSale(int id, Sale sale) {
        Optional<Sale> saleExistente = saleRepository.findById(id);

        if (saleExistente.isPresent()) {
            Sale actual = saleExistente.get();
            actual.setDate(sale.getDate());
            actual.setCustomer(sale.getCustomer());
            actual.setTotalAmount(sale.getTotalAmount());
            actual.setSalesProducts(sale.getSalesProducts());
            return saleRepository.save(actual);
        } else {
            return null;
        }
    }
}
