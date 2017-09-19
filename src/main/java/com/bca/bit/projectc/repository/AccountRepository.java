package com.bca.bit.projectc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bca.bit.projectc.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	public List<Account> findAllByStatusOrderByAccountidAsc(int status);
	public Account findOneByAccountnumber(String accountnumber);
}
