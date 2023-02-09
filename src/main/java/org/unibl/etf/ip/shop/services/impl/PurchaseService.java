package org.unibl.etf.ip.shop.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.shop.models.dtos.PurchaseDTO;
import org.unibl.etf.ip.shop.models.entities.Purchase;
import org.unibl.etf.ip.shop.repositories.PurchaseRepository;
import org.unibl.etf.ip.shop.services.IPurchaseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
//sve metode u ovoj klasi su transakcije, ako se prekine izvrsavanje metode, izmjene ce biti rollback-ovane
public class PurchaseService extends CrudJpaService<Purchase, Integer> implements IPurchaseService {

    private final ModelMapper modelMapper;
    private final PurchaseRepository repository;

    public PurchaseService(ModelMapper modelMapper, PurchaseRepository repository) {
        super(repository, Purchase.class, modelMapper);
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public List<PurchaseDTO> searchByUserId(Integer id) {
        return repository.searchByIdUser(id).stream().map(e -> modelMapper.map(e, PurchaseDTO.class)).collect(Collectors.toList());
    }
}
