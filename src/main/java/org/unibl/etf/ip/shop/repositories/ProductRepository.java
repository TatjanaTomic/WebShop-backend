package org.unibl.etf.ip.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.shop.models.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
