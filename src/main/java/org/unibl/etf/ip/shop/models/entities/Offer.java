package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "offer")
public class Offer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "offer")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id", nullable = false)
    private UserAccount userAccount;

    @ManyToOne
    @JoinColumn(name = "idProduct", referencedColumnName = "id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "offer")
    private List<Purchase> purchases;

}
