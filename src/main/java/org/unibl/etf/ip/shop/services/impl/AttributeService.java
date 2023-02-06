package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ip.shop.models.entities.Attribute;
import org.unibl.etf.ip.shop.repositories.AttributeRepository;
import org.unibl.etf.ip.shop.services.IAttributeService;

import java.util.List;

@Service
@Transactional
public class AttributeService implements IAttributeService {

    private AttributeRepository repository;
    private ModelMapper modelMapper;

    public AttributeService(AttributeRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Attribute> findAttributesOfCategory(Integer idCategory) {
        return repository.findAllByIdCategory(idCategory);
    }
}
