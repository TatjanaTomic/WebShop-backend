package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.dtos.UserAccountDTO;
import org.unibl.etf.ip.shop.models.entities.UserAccount;
import org.unibl.etf.ip.shop.services.IPurchaseService;
import org.unibl.etf.ip.shop.services.IUserAccountService;

@RestController
@RequestMapping("/api/v1/user-accounts")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserAccountController extends CrudController<Integer, UserAccount, UserAccountDTO> {

    private final IUserAccountService userAccountService;
    private final IPurchaseService purchaseService;

    public UserAccountController(IUserAccountService service, IPurchaseService purchaseService) {
        super(UserAccountDTO.class, service);
        this.userAccountService = service;
        this.purchaseService = purchaseService;
    }

    @GetMapping("/username/{username}")
    public UserAccountDTO findByUsername(@PathVariable String username) throws NotFoundException {
        return userAccountService.findByUsername(username);
    }

}
