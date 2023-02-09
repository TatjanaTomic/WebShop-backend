package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.models.dtos.OfferDTO;
import org.unibl.etf.ip.shop.models.entities.Offer;
import org.unibl.etf.ip.shop.services.IOfferService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
@CrossOrigin(origins = "http://localhost:4200/")
public class OfferController extends CrudController<Integer, Offer, OfferDTO> {

    private final IOfferService service;

    public OfferController(IOfferService service) {
        super(OfferDTO.class, service);
        this.service = service;
    }

    @GetMapping("/product/{name}")
    public List<OfferDTO> findByProductName(@PathVariable String name) {
        return service.searchByProductName(name);
    }

    @GetMapping("/existing")
    public List<OfferDTO> findAllExisting() {
        return service.searchAllExisting();
    }


    @GetMapping("/idCategory/{id}")
    public List<OfferDTO> findByIdCategory(@PathVariable Integer id) {
        return service.searchByCategoryId(id);
    }

    @GetMapping("/idUser/{id}")
    public List<OfferDTO> findByIdUser(@PathVariable Integer id) {
        return service.searchByUserId(id);
    }

}
