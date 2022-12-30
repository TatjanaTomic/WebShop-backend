package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "image")
public class Image {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "url", nullable = false, length = 500)
    private String url;

    @ManyToOne
    @JoinColumn(name = "idProduct", referencedColumnName = "id", nullable = false)
    private Product product;

}
