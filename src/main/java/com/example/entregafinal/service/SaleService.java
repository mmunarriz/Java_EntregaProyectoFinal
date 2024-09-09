package com.example.entregafinal.service;

import com.example.entregafinal.model.Product;
import com.example.entregafinal.model.Sale;
import com.example.entregafinal.model.SalesProduct;
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
    private ProductRepository productRepository; // ProductRepository para cargar los productos

    public Sale agregarSale(Sale sale) {
        // Iterar sobre los SalesProducts para cargar los productos desde la base de datos
        for (SalesProduct salesProduct : sale.getSalesProducts()) {
            // Usar productId en lugar de product.getId()
            Product product = productRepository.findById(salesProduct.getProductId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + salesProduct.getProductId()));

            // Asignar el producto recuperado a SalesProduct
            salesProduct.setProduct(product);

            // Asociar la venta con SalesProduct
            salesProduct.setSale(sale);
        }
        // Guardar la venta con los productos correctamente asignados
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
            actual.setSalesProducts(sale.getSalesProducts());
            return saleRepository.save(actual);
        } else {
            return null;
        }
    }
}
