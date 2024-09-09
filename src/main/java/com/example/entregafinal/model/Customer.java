package com.example.entregafinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description= "ID único del cliente", example = "1", accessMode = Schema.AccessMode.READ_ONLY )
    private int id;

    @Schema(description = "Nombre del cliente", example = "Jose Lopez", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "Dirección de correo", example ="jlopez@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Schema(description = "Teléfono de cliente", example ="55553333", requiredMode = Schema.RequiredMode.REQUIRED)
    private String phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @Schema(description = "Lista de ventas asociadas al cliente", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnore
    private List<Sale> sales;

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

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
