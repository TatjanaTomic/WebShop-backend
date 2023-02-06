package org.unibl.etf.ip.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.shop.models.entities.Value;
import org.unibl.etf.ip.shop.models.entities.ValuePK;

public interface ValueRepository extends JpaRepository<Value, ValuePK> {
    Value findByIdProductAndIdAttribute(Integer idProduct, Integer idAttribute);
}
