package com.example.entregafinal.service;

import com.example.entregafinal.model.Customer;
import com.example.entregafinal.model.Product;
import com.example.entregafinal.model.Sale;
import com.example.entregafinal.model.SalesProduct;
import com.example.entregafinal.repository.CustomerRepository;
import com.example.entregafinal.repository.ProductRepository;
import com.example.entregafinal.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Sale agregarSale(Sale sale) {
        // Validar que el cliente existe
        Customer customer = customerRepository.findById(sale.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + sale.getCustomer().getId()));

        sale.setCustomer(customer);

        // Validar que los productos existen
        for (SalesProduct salesProduct : sale.getSalesProducts()) {
            Product product = productRepository.findById(salesProduct.getProductId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + salesProduct.getProductId()));

            salesProduct.setProduct(product);
            salesProduct.setSale(sale);
        }

        return saleRepository.save(sale);
    }
}
