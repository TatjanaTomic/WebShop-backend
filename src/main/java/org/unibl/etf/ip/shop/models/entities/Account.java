package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account {

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

    @ManyToOne
    @JoinColumn(name = "idAccountType", referencedColumnName = "id", nullable = false)
    private AccountType accountType;

}
