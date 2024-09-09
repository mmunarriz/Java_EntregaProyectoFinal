package com.example.entregafinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class SalesProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Campo temporal para recibir el productId desde el request
    @Transient
    private int productId;

    @ManyToOne
    @JoinColumn(name = "saleId")
    @JsonIgnore
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter y Setter para productId
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
