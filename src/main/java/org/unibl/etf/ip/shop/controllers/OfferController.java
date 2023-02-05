package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.shop.models.dtos.OfferDTO;
import org.unibl.etf.ip.shop.models.entities.Offer;
import org.unibl.etf.ip.shop.services.IOfferService;

@RestController
@RequestMapping("/api/v1/offers")
@CrossOrigin(origins="http://localhost:4200/")
public class OfferController extends CrudController<Integer, Offer, OfferDTO>{

    public OfferController(IOfferService service) {
        super(OfferDTO.class, service);
    }

}
