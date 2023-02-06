package org.unibl.etf.ip.shop.models.dtos;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ip.shop.models.entities.Offer;
import org.unibl.etf.ip.shop.models.entities.UserAccount;

@Data
public class CommentDTO {
    private Integer id;
    private String content;
    private UserAccountDTO userAccount;
    private OfferDTO offer;

}
