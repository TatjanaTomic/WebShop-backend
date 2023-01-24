package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.dtos.PurchaseDTO;
import org.unibl.etf.ip.shop.models.requests.PurchaseRequest;

import java.util.List;

public interface IPurchaseService {

    List<PurchaseDTO> findAll();
    PurchaseDTO findById(Integer id) throws NotFoundException;

    List<PurchaseDTO> getAllPurchasesByUserId(Integer id);

    PurchaseDTO insert(PurchaseRequest purchaseRequest) throws NotFoundException;
    PurchaseDTO update(Integer id, PurchaseRequest purchaseRequest) throws NotFoundException;

    // TODO: Brisanje kupovina mi zapravo nije potrebno
    void delete(Integer id);
}
