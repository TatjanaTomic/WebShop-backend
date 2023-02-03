package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.shop.exceptions.ConflictException;
import org.unibl.etf.ip.shop.models.dtos.UserAccountDTO;
import org.unibl.etf.ip.shop.models.entities.UserAccount;
import org.unibl.etf.ip.shop.repositories.UserAccountRepository;
import org.unibl.etf.ip.shop.services.CrudJpaService;
import org.unibl.etf.ip.shop.services.IUserAccountService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAccountService extends CrudJpaService<UserAccount, Integer> implements IUserAccountService {

    private final UserAccountRepository repository;

    public UserAccountService(UserAccountRepository userAccountRepository, ModelMapper modelMapper) {
        super(userAccountRepository, UserAccount.class, modelMapper);
        this.repository = userAccountRepository;
    }

    @Override
    public <T, U> T insert(U object, Class<T> resultDtoClass) {
        if(repository.existsByUsername(getModelMapper().map(object, getEntityClass()).getUsername()))
            throw new ConflictException();
        return super.insert(object, resultDtoClass);
    }

    @Override
    public <T, U> T update(Integer integer, U object, Class<T> resultDtoClass) {
        if(repository.existsByUsernameAndIdNot(getModelMapper().map(object, getEntityClass()).getUsername(), integer))
            throw new ConflictException();
        return super.update(integer, object, resultDtoClass);
    }

    @Override
    public UserAccountDTO findByUsername(String username) {
        return repository.getByUsername(username);
    }
}
