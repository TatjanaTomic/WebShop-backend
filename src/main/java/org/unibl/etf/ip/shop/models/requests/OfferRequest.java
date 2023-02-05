package org.unibl.etf.ip.shop.models.requests;

import lombok.Data;

@Data
public class OfferRequest {
    private Integer id;
    private Integer idUser;
    private Integer idProduct;
    private Boolean isActive;
    private Boolean isDeleted;


}
