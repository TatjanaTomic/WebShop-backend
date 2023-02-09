package org.unibl.etf.ip.shop.models.dtos;

import lombok.Data;

@Data
public class PurchaseDTO {

    private Integer id;
    private String dateTime;
    private String cardNumber;
    private PaymentTypeDTO paymentType;
    private OfferDTO offer;
    private UserAccountDTO userAccount;

}
