package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.PurchaseDTO;
import org.unibl.etf.ip.shop.repositories.PurchaseRepository;
import org.unibl.etf.ip.shop.services.PurchaseServiceInterface;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService implements PurchaseServiceInterface {

    private final ModelMapper modelMapper;
    private final PurchaseRepository repository;

    public PurchaseService(ModelMapper modelMapper, PurchaseRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public List<PurchaseDTO> findAll() {
        return repository.findAll().stream().map(l -> modelMapper.map(l, PurchaseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PurchaseDTO findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new), PurchaseDTO.class);
    }
}
