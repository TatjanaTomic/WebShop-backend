package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.UserAccountDTO;
import org.unibl.etf.ip.shop.models.UserAccountSingleDTO;
import org.unibl.etf.ip.shop.services.UserAccountServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/user-accounts")
public class UserAccountController {

    private final UserAccountServiceInterface service;

    public UserAccountController(UserAccountServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public List<UserAccountDTO> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public UserAccountSingleDTO findById(@PathVariable Integer id) throws NotFoundException {
        return service.findById(id);
    }
}
