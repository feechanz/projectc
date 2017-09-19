package com.bca.bit.projectc.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bca.bit.projectc.model.Account;
import com.bca.bit.projectc.model.ErrorData;
import com.bca.bit.projectc.model.Transaction;
import com.bca.bit.projectc.repository.AccountRepository;
import com.bca.bit.projectc.repository.TransactionRepository;
import com.bca.bit.projectc.service.AccountService;
import com.bca.bit.projectc.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public ResponseEntity<?> getTransactions() {
		List<Transaction> transactions = transactionService.getTransactions();
		return new ResponseEntity(transactions, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/transactions", method = RequestMethod.POST)
	public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction) {
		transaction.setTransactionid(0L);
		if(transaction == null) {
			ErrorData error = new ErrorData();
			error.setCode(100);
			error.setMessage("bad request account number");
			return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		}
		
		
		Account sourceAccount = accountService.getAccount(transaction.getSourceaccountnumber());
		Account targetAccount = accountService.getAccount(transaction.getTargetaccountnumber());
		
		if(sourceAccount != null && targetAccount != null) {
			if(sourceAccount.getAmount() - transaction.getAmount() >= 0) {
				
				transaction.setDatetime(new Timestamp(Calendar.getInstance().getTime().getTime()));
				transaction.setTargetfullname(targetAccount.getFullname());
				
				sourceAccount.setAmount(sourceAccount.getAmount() - transaction.getAmount());
				targetAccount.setAmount(targetAccount.getAmount() + transaction.getAmount());
				accountService.editAccount(sourceAccount);
				accountService.editAccount(targetAccount);
				
				return new ResponseEntity(transactionService.saveTransaction(transaction), HttpStatus.OK);
			}else {
				ErrorData error = new ErrorData();
				error.setCode(101);
				error.setMessage("bad request account amount");
				return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
			}
		}else {
			ErrorData error = new ErrorData();
			error.setCode(100);
			error.setMessage("bad request account number");
			return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
