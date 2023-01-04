package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.PurchaseDTO;

import java.util.List;

public interface PurchaseServiceInterface {

    List<PurchaseDTO> findAll();
    PurchaseDTO findById(Integer id) throws NotFoundException;
}
