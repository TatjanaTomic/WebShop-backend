package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ip.shop.models.BaseEntity;

@Data
@Entity
@Table(name = "comment")
public class Comment implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private UserAccount userAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_offer", referencedColumnName = "id", nullable = false)
    private Offer offer;

}
