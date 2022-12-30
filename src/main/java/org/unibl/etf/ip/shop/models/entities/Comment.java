package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comment")
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    private String content;

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id", nullable = false)
    private UserAccount userAccount;

    @ManyToOne
    @JoinColumn(name = "idOffer", referencedColumnName = "id", nullable = false)
    private Offer offer;

}
