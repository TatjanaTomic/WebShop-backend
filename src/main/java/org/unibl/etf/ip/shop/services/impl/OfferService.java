package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ip.shop.models.dtos.OfferDTO;
import org.unibl.etf.ip.shop.models.entities.Offer;
import org.unibl.etf.ip.shop.repositories.OfferRepository;
import org.unibl.etf.ip.shop.services.IOfferService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OfferService extends CrudJpaService<Offer, Integer> implements IOfferService {

    private final OfferRepository repository;
    private final ModelMapper modelMapper;

    public OfferService(OfferRepository repository, ModelMapper modelMapper) {
        super(repository, Offer.class, modelMapper);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferDTO> searchByProductName(String content) {
        return repository.searchByProductName(content).stream().map(e -> modelMapper.map(e, OfferDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfferDTO> searchByCategoryId(Integer id) {
        return repository.searchByCategoryId(id).stream().map(e -> modelMapper.map(e, OfferDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfferDTO> searchByUserId(Integer id) {
        return repository.searchByIdUser(id).stream().map(e -> modelMapper.map(e, OfferDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<OfferDTO> searchAllExisting() {
        return repository.findAllExisting().stream().map(e -> modelMapper.map(e, OfferDTO.class)).collect(Collectors.toList());
    }
}
