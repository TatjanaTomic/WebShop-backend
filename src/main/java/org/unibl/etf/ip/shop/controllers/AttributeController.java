package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.models.entities.Attribute;
import org.unibl.etf.ip.shop.services.IAttributeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attributes")
@CrossOrigin(origins="http://localhost:4200/")
public class AttributeController {

    IAttributeService service;
    public AttributeController(IAttributeService service) {
        this.service = service;
    }

    @GetMapping("/idCategory/{idCategory}")
    public List<Attribute> getAttributesOfCategory(@PathVariable Integer idCategory) {
        return service.findAttributesOfCategory(idCategory);
    }

}
