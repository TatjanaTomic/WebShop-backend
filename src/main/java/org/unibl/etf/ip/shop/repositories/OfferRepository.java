package org.unibl.etf.ip.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.shop.models.entities.Offer;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
