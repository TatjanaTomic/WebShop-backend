package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ip.shop.models.entities.Product;
import org.unibl.etf.ip.shop.repositories.ProductRepository;
import org.unibl.etf.ip.shop.services.IProductService;

@Service
@Transactional
public class ProductService extends CrudJpaService<Product, Integer> implements IProductService {
    private ProductRepository repository;
    private ModelMapper modelMapper;

    public ProductService(ProductRepository repository, ModelMapper modelMapper) {
        super(repository, Product.class, modelMapper);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
}
