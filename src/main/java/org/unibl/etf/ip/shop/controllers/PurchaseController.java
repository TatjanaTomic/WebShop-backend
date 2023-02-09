package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.models.dtos.PurchaseDTO;
import org.unibl.etf.ip.shop.models.entities.Purchase;
import org.unibl.etf.ip.shop.services.IPurchaseService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchases")
@CrossOrigin(origins = "http://localhost:4200/")
public class PurchaseController extends CrudController<Integer, Purchase, PurchaseDTO> {
    private final IPurchaseService service;

    public PurchaseController(IPurchaseService service) {
        super(PurchaseDTO.class, service);
        this.service = service;
    }

    @GetMapping("/idUser/{id}")
    public List<PurchaseDTO> findByIdUser(@PathVariable Integer id) {
        return service.searchByUserId(id);
    }

}
