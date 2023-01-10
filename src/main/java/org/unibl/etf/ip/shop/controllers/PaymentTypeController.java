package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.PaymentTypeDTO;
import org.unibl.etf.ip.shop.services.PaymentTypeServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/payment-types")
public class PaymentTypeController {

    private final PaymentTypeServiceInterface paymentTypeService;

    public PaymentTypeController(PaymentTypeServiceInterface paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    @GetMapping
    public List<PaymentTypeDTO> findAll() {
        return paymentTypeService.findAll();
    }

    @GetMapping("/{id}")
    public PaymentTypeDTO findById(@PathVariable Integer id) throws NotFoundException {
        return paymentTypeService.findById(id);
    }
}