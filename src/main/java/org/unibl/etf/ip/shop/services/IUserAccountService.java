package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.dtos.UserAccountDTO;
import org.unibl.etf.ip.shop.models.dtos.UserAccountSingleDTO;

import java.util.List;

public interface IUserAccountService {

    List<UserAccountDTO> findAll();
    UserAccountSingleDTO findById(Integer id) throws NotFoundException;
}
