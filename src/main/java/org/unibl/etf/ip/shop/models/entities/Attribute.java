package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@IdClass(AttributePK.class)
@Table(name = "attribute")
public class Attribute {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCategory", nullable = false)
    private Integer idCategory;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToOne
    @JoinColumn(name = "idCategory", referencedColumnName = "id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "attribute")
    private List<Value> values;

}
