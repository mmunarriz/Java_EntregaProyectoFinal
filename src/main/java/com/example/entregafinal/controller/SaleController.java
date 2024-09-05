package com.example.entregafinal.controller;

import com.example.entregafinal.model.Sale;
import com.example.entregafinal.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/agregar")
    public Sale agregarSale(@RequestBody Sale sale) {
        return saleService.agregarSale(sale);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Sale> buscarSale(@PathVariable int id) {
        return saleService.buscarSale(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarSale(@PathVariable int id) {
        saleService.eliminarSale(id);
    }

    @PutMapping("/actualizar/{id}")
    public Sale actualizarSale(@PathVariable int id, @RequestBody Sale sale) {
        return saleService.actualizarSale(id, sale);
    }
}
