package org.unibl.etf.ip.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unibl.etf.ip.shop.models.entities.Purchase;

import java.util.Collection;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query("SELECT p FROM Purchase p WHERE p.userAccount.id=:id")
    List<Purchase> searchByIdUser(Integer id);

}
