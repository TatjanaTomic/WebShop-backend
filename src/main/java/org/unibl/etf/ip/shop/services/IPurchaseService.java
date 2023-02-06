package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.models.dtos.PurchaseDTO;

import java.util.List;

public interface IPurchaseService extends CrudService<Integer> {
    List<PurchaseDTO> searchByUserId(Integer id);
}
