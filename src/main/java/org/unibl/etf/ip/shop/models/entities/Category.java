package org.unibl.etf.ip.shop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ip.shop.models.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    /*@Basic
    @Column(name = "id_parent_category", nullable = true)
    private Integer idParentCategory;*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_parent_category", referencedColumnName = "id", nullable = true)
    private Category parentCategory;

    //@OneToMany(mappedBy = "category")
    //@JsonIgnore
    //private List<Attribute> attributes;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;

}
