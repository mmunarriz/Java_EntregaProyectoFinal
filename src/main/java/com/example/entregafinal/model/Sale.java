package com.example.entregafinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;


    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SalesProduct> salesProducts;


    // Getters y Setters


    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public List<SalesProduct> getSalesProducts() {
        return salesProducts;
    }

    public void setSalesProducts(List<SalesProduct> salesProducts) {
        this.salesProducts = salesProducts;
    }
}
