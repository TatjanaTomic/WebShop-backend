package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ip.shop.models.entities.AttributeValue;
import org.unibl.etf.ip.shop.models.entities.Product;
import org.unibl.etf.ip.shop.repositories.ProductRepository;
import org.unibl.etf.ip.shop.services.IProductService;

import java.util.List;

@Service
@Transactional
public class ProductService extends CrudJpaService<Product, Integer> implements IProductService {
    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository repository, ModelMapper modelMapper) {
        super(repository, Product.class, modelMapper);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AttributeValue> getAttributesAndValues(Integer id) {
        return repository.getAttributesAndValues(id);
    }
}
