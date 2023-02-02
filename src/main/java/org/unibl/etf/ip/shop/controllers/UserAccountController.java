package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.dtos.PurchaseDTO;
import org.unibl.etf.ip.shop.models.dtos.UserAccountDTO;
import org.unibl.etf.ip.shop.models.dtos.UserAccountSingleDTO;
import org.unibl.etf.ip.shop.services.IPurchaseService;
import org.unibl.etf.ip.shop.services.IUserAccountService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-accounts")
@CrossOrigin(origins="http://localhost:4200/")
public class UserAccountController {

    private final IUserAccountService userAccountService;
    private final IPurchaseService purchaseService;

    public UserAccountController(IUserAccountService service, IPurchaseService purchaseService) {
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
