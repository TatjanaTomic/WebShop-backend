package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
public class AttributePK implements Serializable {
    @Column(name = "id", nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) - u PK klasi se ne smije koristiti ova anotacija!
    private Integer id;

    @Column(name = "id_category", nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;

}
