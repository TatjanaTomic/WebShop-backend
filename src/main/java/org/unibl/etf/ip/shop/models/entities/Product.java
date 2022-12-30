package org.unibl.etf.ip.shop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;

    @Basic
    @Column(name = "isNew", nullable = false)
    private Boolean isNew;

    @Basic
    @Column(name = "contact", nullable = false, length = 45)
    private String contact;

    @OneToMany(mappedBy = "product")
    private List<Image> images;

    @OneToMany(mappedBy = "product")
    private List<Offer> offers;

    @ManyToOne
    @JoinColumn(name = "idCategory", referencedColumnName = "id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "idLocation", referencedColumnName = "id")
    private Location location;

    //@OneToMany(mappedBy = "product")
    //@JsonIgnore
    //private List<Value> values;

}
