package org.unibl.etf.ip.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.entities.UserAccount;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    Boolean existsByUsername(String username);

    Optional<UserAccount> findByUsername(String username) throws NotFoundException;

    boolean existsByUsernameAndIdNot(String username, Integer integer);
}
