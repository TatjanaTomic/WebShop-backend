package org.unibl.etf.ip.shop.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ip.shop.models.BaseEntity;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "log")
public class Log implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    private String content;

    @Basic
    @Column(name = "date_time", nullable = false)
    private Timestamp dateTime;

}
