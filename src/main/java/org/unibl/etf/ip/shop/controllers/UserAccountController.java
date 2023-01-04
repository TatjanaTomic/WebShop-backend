package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.PurchaseDTO;
import org.unibl.etf.ip.shop.models.UserAccountDTO;
import org.unibl.etf.ip.shop.models.UserAccountSingleDTO;
import org.unibl.etf.ip.shop.services.PurchaseServiceInterface;
import org.unibl.etf.ip.shop.services.UserAccountServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/user-accounts")
public class UserAccountController {

    private final UserAccountServiceInterface userAccountService;
    private final PurchaseServiceInterface purchaseService;

    public UserAccountController(UserAccountServiceInterface service, PurchaseServiceInterface purchaseService) {
        this.userAccountService = service;
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<UserAccountDTO> findAll() { return userAccountService.findAll(); }

    @GetMapping("/{id}")
    public UserAccountSingleDTO findById(@PathVariable Integer id) throws NotFoundException {
        return userAccountService.findById(id);
    }

    @GetMapping("/{id}/purchases")
    public List<PurchaseDTO> getAllPurchasesByUserId(@PathVariable Integer id) {
        return purchaseService.getAllPurchasesByUserId(id);
    }
}
