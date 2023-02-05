package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.shop.models.dtos.ProductDTO;
import org.unibl.etf.ip.shop.models.entities.Product;
import org.unibl.etf.ip.shop.services.IProductService;
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins="http://localhost:4200/")
public class ProductController extends CrudController<Integer, Product, ProductDTO>{

    public ProductController(IProductService service) {
        super(ProductDTO.class, service);
    }
}
