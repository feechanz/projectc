package com.bca.bit.projectc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bca.bit.projectc.model.Account;
import com.bca.bit.projectc.repository.AccountRepository;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@RequestMapping("/accounts/{id}")
    public Account product(@PathVariable Long id){
        Account account = accountRepository.findOne(id);
        return account;
    }
 
    @RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> productsList(){
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }
 
    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    @ResponseBody
    public Account saveProduct(@RequestBody Account account) {
        return accountRepository.save(account);
    }
    
}
