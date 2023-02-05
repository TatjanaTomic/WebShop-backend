package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ip.shop.models.entities.Category;
import org.unibl.etf.ip.shop.repositories.CategoryRepository;
import org.unibl.etf.ip.shop.services.ICategoryService;

@Service
@Transactional
public class CategoryService extends CrudJpaService<Category, Integer> implements ICategoryService {
    private CategoryRepository repository;
    private ModelMapper modelMapper;

    public CategoryService(CategoryRepository repository, ModelMapper mapper) {
        super(repository, Category.class, mapper);
        this.repository = repository;
        this.modelMapper = mapper;
    }
}
