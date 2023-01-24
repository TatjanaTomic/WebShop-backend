package org.unibl.etf.ip.shop.models.requests;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PurchaseRequest {

    private Timestamp dateTime;
    private String cardNumber;
    private Integer offerId;
    private Integer paymentTypeId;
    private Integer userAccountId;

}
