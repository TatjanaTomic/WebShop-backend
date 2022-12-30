package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user_account")
public class UserAccount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "firstName", nullable = false, length = 45)
    private String firstName;

    @Basic
    @Column(name = "lastName", nullable = false, length = 45)
    private String lastName;

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @Basic
    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @Basic
    @Column(name = "avatar", length = 500)
    private String avatar;

    @Basic
    @Column(name = "mail", nullable = false, length = 45)
    private String mail;

    @Basic
    @Column(name = "pin", nullable = false, length = 45)
    private String pin;

    @Basic
    @Column(name = "isActivated", nullable = false)
    private Boolean isActivated;

    @Basic
    @Column(name = "isDeleted", nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "userAccount")
    private List<Comment> comments;

    @OneToMany(mappedBy = "userAccount")
    private List<Message> messages;

    @OneToMany(mappedBy = "userAccount")
    private List<Offer> offers;

    @OneToMany(mappedBy = "userAccount")
    private List<Purchase> purchases;

}
