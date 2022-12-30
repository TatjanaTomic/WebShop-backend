package org.unibl.etf.ip.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.shop.models.entities.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
}
