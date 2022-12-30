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
    @Column(name = "idProduct", nullable = false)
    private Integer idProduct;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idAttribute", nullable = false)
    private Integer idAttribute;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCategory", nullable = false)
    private Integer idCategory;

    @Basic
    @Column(name = "value", nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "idProduct", referencedColumnName = "id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "idAttribute", referencedColumnName = "id", nullable = false), @JoinColumn(name = "idCategory", referencedColumnName = "idCategory", nullable = false)})
    private Attribute attribute;

}
