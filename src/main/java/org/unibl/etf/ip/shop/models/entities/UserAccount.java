package org.unibl.etf.ip.shop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ip.shop.models.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "user_account")
public class UserAccount implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
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
    @Column(name = "is_activated", nullable = false)
    private Boolean isActivated;

    @Basic
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "userAccount")
    @JsonIgnore
    private List<Comment> comments;

    //@OneToMany(mappedBy = "userAccount")
    //private List<Message> messages;

    //@OneToMany(mappedBy = "userAccount")
    //private List<Offer> offers;

    @OneToMany(mappedBy = "userAccount")
    @JsonIgnore
    private List<Purchase> purchases;

}
