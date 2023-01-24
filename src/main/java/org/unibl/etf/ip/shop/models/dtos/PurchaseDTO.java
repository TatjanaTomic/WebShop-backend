package org.unibl.etf.ip.shop.models.dtos;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PurchaseDTO {

    private Integer id;

    private Timestamp dateTime;

    private String cardNumber;

    //umjesto da cuvam citav objekat PaymentType, zelim samo naziv
    private String paymentTypeName;

    //Offer
    private Integer offerId;

    //UserAccount
    private String userAccountUsername;

}
