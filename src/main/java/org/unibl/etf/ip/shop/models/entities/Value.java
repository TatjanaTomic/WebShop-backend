package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@IdClass(ValuePK.class)
@Table(name = "value")
public class Value {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_product", nullable = false)
    private Integer idProduct;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_attribute", nullable = false)
    private Integer idAttribute;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_category", nullable = false)
    private Integer idCategory;

    @Basic
    @Column(name = "value", nullable = false)
    private String value;

    //@ManyToOne
    //@JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    //private Product product;

    //@ManyToOne
    //@JoinColumns({@JoinColumn(name = "id_attribute", referencedColumnName = "id", nullable = false), @JoinColumn(name = "id_category", referencedColumnName = "id_category", nullable = false)})
    //private Attribute attribute;

}
