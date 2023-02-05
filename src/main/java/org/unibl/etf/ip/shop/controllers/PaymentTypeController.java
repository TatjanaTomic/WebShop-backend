package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.models.dtos.PaymentTypeDTO;
import org.unibl.etf.ip.shop.models.entities.PaymentType;
import org.unibl.etf.ip.shop.services.IPaymentTypeService;

@RestController
@RequestMapping("/api/v1/payment-types")
@CrossOrigin(origins="http://localhost:4200/")
public class PaymentTypeController extends CrudController<Integer, PaymentType, PaymentTypeDTO> {

    public PaymentTypeController(IPaymentTypeService service) {
        super(PaymentTypeDTO.class, service);
    }
}