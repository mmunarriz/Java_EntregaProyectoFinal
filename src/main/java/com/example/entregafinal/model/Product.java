package com.example.entregafinal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description= "ID único del producto", example = "1", accessMode = Schema.AccessMode.READ_ONLY )
    private int id;

    @Schema(description = "Nombre del producto", example ="samsung s22", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "Precio del producto", example ="40000", requiredMode = Schema.RequiredMode.REQUIRED)
    private double price;


    // Getters y Setters


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
