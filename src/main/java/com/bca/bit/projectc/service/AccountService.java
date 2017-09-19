package com.bca.bit.projectc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bca.bit.projectc.model.Account;
import com.bca.bit.projectc.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;
	
    public Account getAccount(String accountnumber){
        Account account = accountRepository.findOneByAccountnumber(accountnumber);
        return account;
    }
 
    public List<Account> getActiveAccounts(){
        List<Account> accounts = accountRepository.findAllByStatusOrderByAccountidAsc(1);
        return accounts;
    }
 
    public Account insertAccount(@RequestBody Account account) {
    	account.setAccountid(0L);
        return accountRepository.save(account);
    }
    
    public Account editAccount(@RequestBody Account account) {
    	return accountRepository.save(account);
    }
}
