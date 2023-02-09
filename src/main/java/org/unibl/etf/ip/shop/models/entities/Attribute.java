package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@IdClass(AttributePK.class)
@Table(name = "attribute")
public class Attribute {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_category", nullable = false, insertable = false, updatable = false)
    private Integer idCategory;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    //@ManyToOne
    //@JoinColumn(name = "id_category", referencedColumnName = "id", nullable = false)
    //private Category category;

    //@OneToMany(mappedBy = "attribute")
    //@JsonIgnore
    //private List<Value> values;

}
