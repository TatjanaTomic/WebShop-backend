package org.unibl.etf.ip.shop.models.dtos;

import lombok.Data;

@Data
public class OfferDTO {

    private Integer id;
    private Integer idUser;
    private ProductDTO product;
    private Boolean isActive;
    private Boolean isDeleted;

}
