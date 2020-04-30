package com.capg.dao;

import java.util.List;


import com.capg.model.Online;
import com.capg.model.Transaction;

public interface OnlineDao {
	public abstract Online createAccount(Online bank);

	public abstract Online showBalance(Long accNo);

	public abstract Online deposite(Long accNo, Double depositeAmount);

	public abstract Online getAccount(Long accNo);

	public abstract Online withdraw(Long accNo, Double withdrawAmount);

	
	  public abstract List<Transaction> printTransactions(Long accNo);
	 
	public abstract Online fundTransfer(Long saccNo, Long raccNo, Double transferAmount);
}
