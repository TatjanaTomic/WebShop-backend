package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.models.entities.Value;
import org.unibl.etf.ip.shop.services.IValueService;

@RestController
@RequestMapping("/api/v1/values")
@CrossOrigin(origins="http://localhost:4200/")
public class ValueController {
    private IValueService service;
    public ValueController(IValueService service) {
        this.service = service;
    }

    @GetMapping("/idProduct/{idProduct}/idAttribute/{idAttribute}")
    public Value getValueOfAttributeForProduct(@PathVariable Integer idProduct, @PathVariable Integer idAttribute) {
        return service.getByIdProductAndIdAttribute(idProduct, idAttribute);
    }
}
