package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.models.PaymentTypeDTO;

import java.util.List;

public interface PaymentTypeServiceInterface {
    List<PaymentTypeDTO> findAll();

    PaymentTypeDTO findById(Integer id);
}
