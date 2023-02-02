package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.shop.models.entities.Account;
import org.unibl.etf.ip.shop.repositories.AccountRepository;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins="http://localhost:4200/")
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
