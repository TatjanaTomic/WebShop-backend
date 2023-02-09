package org.unibl.etf.ip.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unibl.etf.ip.shop.models.entities.Offer;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

    @Query("SELECT o FROM Offer o WHERE o.product.name LIKE CONCAT('%', :content, '%') ")
    List<Offer> searchByProductName(String content);

    @Query("SELECT o FROM Offer o WHERE o.product.category.id=:id")
    List<Offer> searchByCategoryId(Integer id);

    @Query("SELECT o FROM Offer o WHERE o.idUser=:id AND o.isDeleted=false")
    List<Offer> searchByIdUser(Integer id);

    @Query("SELECT o FROM Offer o WHERE o.isActive=true AND o.isDeleted=false")
    List<Offer> findAllExisting();
}
