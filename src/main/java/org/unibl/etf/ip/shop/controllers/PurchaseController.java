package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.PurchaseDTO;
import org.unibl.etf.ip.shop.services.PurchaseServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseServiceInterface service;

    public PurchaseController(PurchaseServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public List<PurchaseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PurchaseDTO findById(@PathVariable Integer id) throws NotFoundException {
        return service.findById(id);
    }
}
