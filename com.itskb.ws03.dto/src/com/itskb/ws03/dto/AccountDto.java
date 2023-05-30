package com.itskb.ws03.dto;

public class AccountDto {  //계좌클래스
	private int accountSeq;
	private String accountNumber;
	private int balance;
	private int userSeq;

	public AccountDto(int accountSeq, String accountNumber, int balance, int userSeq) {
		super();
		this.accountSeq = accountSeq;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.userSeq = userSeq;
	}

	public int getAccountSeq() {
		return accountSeq;
	}

	public void setAccountSeq(int accountSeq) {
		this.accountSeq = accountSeq;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	@Override
	public String toString() {
		return "AccountDto [accountSeq=" + accountSeq + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", userSeq=" + userSeq + "]";
	}
	
	
	
	
//	
//	
//	public AccountDto(int accountSeq, String accountNumber, int balance, int userSeq) {
//		this.accountSeq = accountSeq;
//		this.accountNumber = accountNumber;
//		this.balance = balance;
//		this.userSeq = userSeq;
//	}
//	
//	
//	
//	public String getAccountNumber() {
//		return accountNumber;
//	}
//	public int getAccountSeq() {
//		return accountSeq;
//	}
//	public int getBalance() {
//		return balance;
//	}
//	public int getUserSeq() {
//		return userSeq;
//	}
//	
//	
//	public void setAccountNumber(String accountNumber) {
//		this.accountNumber = accountNumber;
//	}
//	public void setAccountSeq(int accountSeq) {
//		this.accountSeq = accountSeq;
//	}
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
//	public void setUserSeq(int userSeq) {
//		this.userSeq = userSeq;
//	}
//
//
//	public String toString() {
//		return "accountNumber = "+ accountNumber + ", accountSeq = " + accountSeq + ", getBalance = " + balance + ", userSeq = " + userSeq;
//	}
}


