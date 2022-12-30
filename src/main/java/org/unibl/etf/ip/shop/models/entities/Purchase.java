package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "purchase")
public class Purchase {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "dateTime", nullable = false)
    private Timestamp dateTime;

    @Basic
    @Column(name = "cardNumber", length = 45)
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "idOffer", referencedColumnName = "id", nullable = false)
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "idPaymentType", referencedColumnName = "id", nullable = false)
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id", nullable = false)
    private UserAccount userAccount;

}
