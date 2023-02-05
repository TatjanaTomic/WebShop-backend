package org.unibl.etf.ip.shop.models.requests;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean isNew;
    private String contact;
    private Integer idCategory;
    private String address;
}
