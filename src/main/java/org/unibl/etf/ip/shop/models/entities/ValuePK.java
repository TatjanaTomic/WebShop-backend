package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
public class ValuePK implements Serializable {
    @Column(name = "id_product", nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) - u kompozitnom kljucu se ne smije koristiti ova anotacija
    private Integer idProduct;

    @Column(name = "id_attribute", nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAttribute;

    @Column(name = "id_category", nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;

}
