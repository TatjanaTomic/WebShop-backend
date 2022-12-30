package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.shop.models.entities.AccountType;
import org.unibl.etf.ip.shop.repositories.AccountTypeRepository;

import java.util.List;

@RestController
@RequestMapping("/account-types")
public class AccountTypeController {

    private final AccountTypeRepository accountTypeRepository;

    public AccountTypeController(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @GetMapping
    public List<AccountType> findAll() {
        return accountTypeRepository.findAll();
    }
}
