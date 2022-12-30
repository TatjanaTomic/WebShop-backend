package org.unibl.etf.ip.shop.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "idCategory", nullable = false, insertable=false, updatable=false)
    private Integer idCategory;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    //@ManyToOne
    //@JoinColumn(name = "idCategory", referencedColumnName = "id", nullable = false)
    //private Category category;

    //@OneToMany(mappedBy = "attribute")
    //@JsonIgnore
    //private List<Value> values;

}
