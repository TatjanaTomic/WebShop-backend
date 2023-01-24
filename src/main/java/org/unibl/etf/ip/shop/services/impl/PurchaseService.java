package org.unibl.etf.ip.shop.services.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.dtos.PurchaseDTO;
import org.unibl.etf.ip.shop.models.requests.PurchaseRequest;
import org.unibl.etf.ip.shop.models.entities.Purchase;
import org.unibl.etf.ip.shop.repositories.PurchaseRepository;
import org.unibl.etf.ip.shop.services.IPurchaseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional //sve metode u ovoj klasi su transakcije, ako se prekine izvrsavanje metode, izmjene ce biti rollback-ovane
public class PurchaseService implements IPurchaseService {

    private final ModelMapper modelMapper;
    private final PurchaseRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public List<PurchaseDTO> getAllPurchasesByUserId(Integer id) {
        return repository.getAllByUserAccount_Id(id).stream().map(a -> modelMapper.map(a, PurchaseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PurchaseDTO insert(PurchaseRequest purchaseRequest) throws NotFoundException {
        Purchase purchase = modelMapper.map(purchaseRequest, Purchase.class);
        purchase.setId(null);

        purchase = repository.saveAndFlush(purchase);

        entityManager.refresh(purchase);

        return findById(purchase.getId());
    }

    @Override
    public PurchaseDTO update(Integer id, PurchaseRequest purchaseRequest) throws NotFoundException {
        Purchase purchase = modelMapper.map(purchaseRequest, Purchase.class);
        purchase.setId(id);

        purchase = repository.saveAndFlush(purchase);

        entityManager.refresh(purchase);

        return findById(purchase.getId());
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
