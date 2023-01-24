package org.unibl.etf.ip.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.shop.models.entities.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {
    Boolean existsByName(String name);
    Boolean existsByNameAndIdNot(String name, Integer id);
}
