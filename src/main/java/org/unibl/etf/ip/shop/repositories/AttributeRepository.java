package org.unibl.etf.ip.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.shop.models.entities.Attribute;
import org.unibl.etf.ip.shop.models.entities.AttributePK;

import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, AttributePK> {
    List<Attribute> findAllByIdCategory(Integer idCategory);
}
