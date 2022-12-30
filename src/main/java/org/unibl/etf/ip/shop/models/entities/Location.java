package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "location")
public class Location {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "latitude", nullable = false)
    private Integer latitude;

    @Basic
    @Column(name = "longitude", nullable = false)
    private Integer longitude;

    @OneToMany(mappedBy = "location")
    private List<Product> products;

}
