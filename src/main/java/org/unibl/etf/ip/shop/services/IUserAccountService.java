package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.models.dtos.UserAccountDTO;

public interface IUserAccountService extends CrudService<Integer> {

    UserAccountDTO findByUsername(String username);
}
