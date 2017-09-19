package com.bca.bit.projectc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = Account.TABLE_NAME)
public class Account{
	public static final String TABLE_NAME = "TBL_ACCOUNT";
	public static final String COLUMN_ID = "ACCOUNT_ID";
	public static final String COLUMN_ACCOUNT_NUMBER = "ACCOUNT_NUMBER";
	public static final String COLUMN_FULLNAME = "FULLNAME";
	public static final String COLUMN_PASSWORD = "PASSWORD";
	public static final String COLUMN_AMOUNT = "AMOUNT";
	public static final String COLUMN_STATUS = "STATUS";
	
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long accountid;
	
	@Column(name = COLUMN_ACCOUNT_NUMBER, nullable = true, length = 10)
	private String accountnumber;
	
	@Column(name = COLUMN_FULLNAME, nullable = true, length = 100)
	private String fullname;
	
	@Column(name = COLUMN_PASSWORD, nullable = true, length = 100)
	private String password;
	
	@Column(name = COLUMN_AMOUNT, nullable = true)
	private Double amount;
	
	@Column(name = COLUMN_STATUS, nullable = true)
	private Integer status;

}
