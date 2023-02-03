package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.dtos.PurchaseDTO;

import java.util.List;

public interface IPurchaseService {

    List<PurchaseDTO> findAll();
    PurchaseDTO findById(Integer id) throws NotFoundException;

    List<PurchaseDTO> getAllPurchasesByUserId(Integer id);

    PurchaseDTO insert(PurchaseDTO purchaseRequest) throws NotFoundException;

    PurchaseDTO update(Integer id, PurchaseDTO purchaseRequest) throws NotFoundException;

    void delete(Integer id);
}
