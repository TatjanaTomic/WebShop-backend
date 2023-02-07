package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.dtos.ProductDTO;
import org.unibl.etf.ip.shop.models.dtos.UserAccountDTO;
import org.unibl.etf.ip.shop.models.entities.AttributeValue;
import org.unibl.etf.ip.shop.models.entities.Product;
import org.unibl.etf.ip.shop.services.IProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins="http://localhost:4200/")
public class ProductController extends CrudController<Integer, Product, ProductDTO>{

    IProductService productService;
    public ProductController(IProductService service) {
        super(ProductDTO.class, service);
        productService = service;
    }

    @GetMapping("/attributes-values/{id}")
    public List<AttributeValue> getAttributesAndValues(@PathVariable Integer id) {
        return productService.getAttributesAndValues(id);
    }
}
