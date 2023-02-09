package org.unibl.etf.ip.shop.models.dtos;

import lombok.Data;

@Data
public class CommentDTO {

    private Integer id;
    private String content;
    private UserAccountDTO userAccount;
    private OfferDTO offer;

}
