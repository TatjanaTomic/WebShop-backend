package org.unibl.etf.ip.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unibl.etf.ip.shop.models.entities.AttributeValue;
import org.unibl.etf.ip.shop.models.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT new org.unibl.etf.ip.shop.models.entities.AttributeValue(v.idProduct, a.id, a.name, v.value)" +
            " FROM Attribute a INNER JOIN Value v ON a.id=v.idAttribute WHERE v.idProduct=:id")
    List<AttributeValue> getAttributesAndValues(Integer id);
}
