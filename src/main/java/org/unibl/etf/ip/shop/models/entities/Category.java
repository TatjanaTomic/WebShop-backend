package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic
    @Column(name = "isDeleted", nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "category")
    private List<Attribute> attributes;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
