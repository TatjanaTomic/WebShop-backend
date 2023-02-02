package org.unibl.etf.ip.shop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.dtos.PurchaseDTO;
import org.unibl.etf.ip.shop.models.requests.PurchaseRequest;
import org.unibl.etf.ip.shop.services.IPurchaseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchases")
@CrossOrigin(origins="http://localhost:4200/")
public class PurchaseController {

    private final IPurchaseService service;

    public PurchaseController(IPurchaseService service) {
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
