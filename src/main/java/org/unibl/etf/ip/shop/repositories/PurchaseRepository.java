package org.unibl.etf.ip.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.shop.models.entities.Purchase;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    //TODO: U repozitorijumu mozemo pisati metode kao da pisemo SQL upit !!!
    List<Purchase> getAllByUserAccount_Id(Integer id);

    // Takodje mozemo definisati neku metodu nestandardnog naziva, anotirati je sa @Query i napisati odgovarajuci JPQL upit
    //@Query("SELECT p FROM Purchase p WHERE p.userAccount.id=:id")
    //List<Purchase> getByUserId(Integer id);
}
