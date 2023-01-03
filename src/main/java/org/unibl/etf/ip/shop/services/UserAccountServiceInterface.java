package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.UserAccountDTO;
import org.unibl.etf.ip.shop.models.UserAccountSingleDTO;

import java.util.List;

public interface UserAccountServiceInterface {

    List<UserAccountDTO> findAll();
    UserAccountSingleDTO findById(Integer id) throws NotFoundException;
}
