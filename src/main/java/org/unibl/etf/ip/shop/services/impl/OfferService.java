package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ip.shop.models.entities.Offer;
import org.unibl.etf.ip.shop.repositories.OfferRepository;
import org.unibl.etf.ip.shop.services.IOfferService;

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

}
