package org.unibl.etf.ip.shop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.PurchaseDTO;
import org.unibl.etf.ip.shop.models.PurchaseRequest;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseDTO insert(@RequestBody PurchaseRequest purchaseRequest) throws NotFoundException {
        return service.insert(purchaseRequest);
    }

    @PutMapping("/{id}")
    public PurchaseDTO update(@PathVariable Integer id, @RequestBody PurchaseRequest purchaseRequest) throws NotFoundException {
        return service.update(id, purchaseRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
