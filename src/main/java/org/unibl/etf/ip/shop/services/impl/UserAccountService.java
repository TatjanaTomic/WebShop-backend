package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ip.shop.exceptions.ConflictException;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.dtos.UserAccountDTO;
import org.unibl.etf.ip.shop.models.entities.UserAccount;
import org.unibl.etf.ip.shop.repositories.UserAccountRepository;
import org.unibl.etf.ip.shop.services.IUserAccountService;

@Service
@Transactional
public class UserAccountService extends CrudJpaService<UserAccount, Integer> implements IUserAccountService {

    private final UserAccountRepository repository;
    private final ModelMapper modelMapper;

    public UserAccountService(UserAccountRepository userAccountRepository, ModelMapper modelMapper) {
        super(userAccountRepository, UserAccount.class, modelMapper);
        this.repository = userAccountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public <T, U> T insert(U object, Class<T> resultDtoClass) {
        if (repository.existsByUsername(getModelMapper().map(object, getEntityClass()).getUsername()))
            throw new ConflictException();
        return super.insert(object, resultDtoClass);
    }

    @Override
    public <T, U> T update(Integer integer, U object, Class<T> resultDtoClass) {
        if (repository.existsByUsernameAndIdNot(getModelMapper().map(object, getEntityClass()).getUsername(), integer))
            throw new ConflictException();
        return super.update(integer, object, resultDtoClass);
    }

    @Override
    public UserAccountDTO findByUsername(String username) throws NotFoundException {
        return modelMapper.map(repository.findByUsername(username).orElseThrow(NotFoundException::new), UserAccountDTO.class);
    }
}
