package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.dtos.UserAccountDTO;
import org.unibl.etf.ip.shop.models.dtos.UserAccountSingleDTO;
import org.unibl.etf.ip.shop.repositories.UserAccountRepository;
import org.unibl.etf.ip.shop.services.IUserAccountService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAccountService implements IUserAccountService {

    private final ModelMapper modelMapper;
    private final UserAccountRepository repository;

    public UserAccountService(UserAccountRepository userAccountRepository, ModelMapper modelMapper) {
        this.repository = userAccountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserAccountDTO> findAll() {
        return repository.findAll().stream().map(l -> modelMapper.map(l, UserAccountDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserAccountSingleDTO findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new), UserAccountSingleDTO.class);
    }
}
