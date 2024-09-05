package com.example.entregafinal.controller;

import com.example.entregafinal.model.Customer;
import com.example.entregafinal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/agregar")
    public Customer agregarCustomer(@RequestBody Customer customer) {
        return customerService.agregarCustomer(customer);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Customer> buscarCustomer(@PathVariable int id) {
        return customerService.buscarCustomer(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarCustomer(@PathVariable int id) {
        customerService.eliminarCustomer(id);
    }

    @PutMapping("/actualizar/{id}")
    public Customer actualizarCustomer(@PathVariable int id, @RequestBody Customer customer) {
        return customerService.actualizarCustomer(id, customer);
    }

}
