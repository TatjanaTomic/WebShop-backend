package org.unibl.etf.ip.shop.models.dtos;

import lombok.Data;

@Data
public class UserAccountDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String city;
    private String avatar;
    private String mail;
    private String pin;
    private Boolean isActivated;
    private Boolean isDeleted;
}
