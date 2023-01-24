package org.unibl.etf.ip.shop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ip.shop.models.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "offer")
public class Offer implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "offer")
    private List<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private UserAccount userAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "offer")
    @JsonIgnore
    private List<Purchase> purchases;

}
