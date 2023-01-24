package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.dtos.PaymentTypeDTO;
import org.unibl.etf.ip.shop.models.entities.PaymentType;
import org.unibl.etf.ip.shop.models.requests.PaymentTypeRequest;
import org.unibl.etf.ip.shop.services.CrudService;
import org.unibl.etf.ip.shop.services.IPaymentTypeService;

import java.util.List;

@RestController
@RequestMapping("/payment-types")
public class PaymentTypeController extends CrudController<Integer, PaymentTypeRequest, PaymentTypeDTO> {

    protected PaymentTypeController(IPaymentTypeService service) {
        super(PaymentTypeDTO.class, service);
    }
}