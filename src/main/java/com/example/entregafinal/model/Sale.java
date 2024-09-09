package com.example.entregafinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Schema(
        description = "Modelo de la venta",
        example = "{ \"customer\": { \"id\": 1 }, \"date\": \"2024-09-09\", \"salesProducts\": [ { \"productId\": 1, \"quantity\": 3 }, { \"productId\": 2, \"quantity\": 1 } ] }"
)

public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID de la venta", hidden = true)
    private int id;

    @Schema(description = "Fecha de la venta", example = "2024-09-09", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "customerId")

    @Schema(description = "ID del cliente que efectúa la compra", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Customer customer;


    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    @Schema(
            description = "Lista de productos vendidos en la venta",
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[{\"productId\": 1, \"quantity\": 3}, {\"productId\": 2, \"quantity\": 1}]"
    )
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
