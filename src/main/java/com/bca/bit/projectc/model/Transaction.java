package com.bca.bit.projectc.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = Transaction.TABLE_NAME)
public class Transaction {
	public static final String TABLE_NAME = "TBL_TRANSACTION";
	public static final String COLUMN_ID = "TRANSACTION_ID";
	public static final String COLUMN_SOURCE_ACCOUNT_NUMBER = "SOURCE_ACCOUNT_NUMBER";
	public static final String COLUMN_TARGET_ACCOUNT_NUMBER = "TARGET_ACCOUNT_NUMBER";
	public static final String COLUMN_TARGET_FULLNAME = "TARGET_FULLNAME";
	public static final String COLUMN_AMOUNT = "AMOUNT";
	public static final String COLUMN_DATETIME = "DATETIME";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long transactionid;
	
	@Column(name = COLUMN_SOURCE_ACCOUNT_NUMBER, nullable = true)
	private String sourceaccountnumber;
	
	@Column(name = COLUMN_TARGET_ACCOUNT_NUMBER, nullable = true)
	private String targetaccountnumber;
	
	@Column(name = COLUMN_TARGET_FULLNAME, nullable = true)
	private String targetfullname;
	
	@Column(name = COLUMN_AMOUNT, nullable = true)
	private double amount;
	
	@Column(name = COLUMN_DATETIME, nullable = true)
	private Timestamp datetime;
	
	
}

