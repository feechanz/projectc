package com.bca.bit.projectc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bca.bit.projectc.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
}
