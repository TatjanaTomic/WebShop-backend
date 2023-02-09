package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.shop.models.dtos.CategoryDTO;
import org.unibl.etf.ip.shop.models.entities.Category;
import org.unibl.etf.ip.shop.services.ICategoryService;

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin(origins = "http://localhost:4200/")
public class CategoryController extends CrudController<Integer, Category, CategoryDTO> {

    public CategoryController(ICategoryService service) {
        super(CategoryDTO.class, service);
    }


}
