package com.example.entregafinal.controller;

import com.example.entregafinal.model.Sale;
import com.example.entregafinal.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
@Tag(name = "Sales", description = "Operaciones relacionadas con las ventas")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/agregar")
    @Operation(summary = "Agregar una nueva venta", description = "Agrega una nueva venta al sistema")
    public ResponseEntity<String> agregarSale(@RequestBody Sale sale) {
        try {
            saleService.agregarSale(sale);
            return ResponseEntity.ok("Venta creada con éxito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
