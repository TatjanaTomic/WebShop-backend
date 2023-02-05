package org.unibl.etf.ip.shop.models.dtos;

import lombok.Data;

@Data
public class CategoryDTO {
    private Integer id;
    private String name;
    private Integer idParentCategory;
    private boolean isDeleted;
}
