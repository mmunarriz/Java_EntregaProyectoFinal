package com.example.entregafinal.controller;

import com.example.entregafinal.model.Sale;
import com.example.entregafinal.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sales")
@Tag(name = "Sales", description = "Operaciones relacionadas con las ventas")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/agregar")
    @Operation(summary="Agregar un nueva venta", description = "Agrega un nueva venta al sistema")
    public Sale agregarSale(@RequestBody Sale sale) {
        return saleService.agregarSale(sale);
    }

}
