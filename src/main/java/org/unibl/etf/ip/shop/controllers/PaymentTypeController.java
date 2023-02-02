package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.models.dtos.PaymentTypeDTO;
import org.unibl.etf.ip.shop.models.requests.PaymentTypeRequest;
import org.unibl.etf.ip.shop.services.IPaymentTypeService;

@RestController
@RequestMapping("/payment-types")
@CrossOrigin(origins="http://localhost:4200/")
public class PaymentTypeController extends CrudController<Integer, PaymentTypeRequest, PaymentTypeDTO> {

    protected PaymentTypeController(IPaymentTypeService service) {
        super(PaymentTypeDTO.class, service);
    }
}