package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.models.dtos.OfferDTO;

import java.util.List;

public interface IOfferService extends CrudService<Integer> {
    List<OfferDTO> searchByProductName(String content);
    List<OfferDTO> searchByCategoryId(Integer id);
    List<OfferDTO> searchByUserId(Integer id);

    List<OfferDTO> searchAllExisting();
}
