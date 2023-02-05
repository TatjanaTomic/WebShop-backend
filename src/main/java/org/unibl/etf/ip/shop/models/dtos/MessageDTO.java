package org.unibl.etf.ip.shop.models.dtos;

import lombok.Data;

@Data
public class MessageDTO {
    private Integer id;
    private String content;
    private Integer idUser;
    private Boolean isRead;
    private String dateTime;
}
