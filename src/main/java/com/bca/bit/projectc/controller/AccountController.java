package com.bca.bit.projectc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bca.bit.projectc.model.Account;
import com.bca.bit.projectc.repository.AccountRepository;
import com.bca.bit.projectc.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping("/accounts/{accountnumber}")
    public ResponseEntity<?> getAccount(@PathVariable String accountnumber){
        Account account = accountService.getAccount(accountnumber);
        return new ResponseEntity(account, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getActiveAccounts(){
        List<Account> accounts = accountService.getActiveAccounts();
        return new ResponseEntity(accounts, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> saveAccount(@RequestBody Account account) {
        return new ResponseEntity(accountService.insertAccount(account), HttpStatus.OK);
    }
}
