package org.unibl.etf.ip.shop.models.dtos;

import lombok.Data;
import org.unibl.etf.ip.shop.models.entities.Category;

@Data
public class CategoryDTO {
    private Integer id;
    private String name;
    //private Integer idParentCategory;
    private Category parentCategory;
    private boolean isDeleted;
}
