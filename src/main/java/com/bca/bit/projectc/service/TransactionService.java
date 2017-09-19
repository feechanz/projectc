package com.bca.bit.projectc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bca.bit.projectc.model.Transaction;
import com.bca.bit.projectc.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;
	
	public List<Transaction> getTransactions() {
		List<Transaction> transactions = transactionRepository.findAll();
		return transactions;
	}
	
	public Transaction saveTransaction(Transaction transaction) {
		transaction.setTransactionid(0L);
		return transactionRepository.save(transaction);
	}
}
