package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.PaymentTypeDTO;
import org.unibl.etf.ip.shop.repositories.PaymentTypeRepository;
import org.unibl.etf.ip.shop.services.PaymentTypeServiceInterface;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentTypeService implements PaymentTypeServiceInterface {

    private final ModelMapper modelMapper;
    private final PaymentTypeRepository repository;

    public PaymentTypeService(ModelMapper modelMapper, PaymentTypeRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public List<PaymentTypeDTO> findAll() {
        return repository.findAll().stream().map(l -> modelMapper.map(l, PaymentTypeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PaymentTypeDTO findById(Integer id) {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new), PaymentTypeDTO.class);
    }
}
