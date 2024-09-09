package com.example.entregafinal.controller;

import com.example.entregafinal.model.Customer;
import com.example.entregafinal.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customers", description = "Operaciones relacionadas con los clientes")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/agregar")
    @Operation(summary="Agregar un nuevo cliente", description = "Agrega un nuevo cliente al sistema")
    public Customer agregarCustomer(@RequestBody Customer customer) {
        return customerService.agregarCustomer(customer);
    }

    @DeleteMapping("/eliminar/{id}")
    @Operation(summary="Eliminar un cliente por ID", description="Elimina un cliente utilizando su numero de ID")
    public void eliminarCustomer(@PathVariable int id) {
        customerService.eliminarCustomer(id);
    }

}
