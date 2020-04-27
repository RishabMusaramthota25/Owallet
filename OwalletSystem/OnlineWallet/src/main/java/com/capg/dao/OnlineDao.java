package com.capg.dao;

import java.util.List;


import com.capg.model.Online;
import com.capg.model.Transaction;

public interface OnlineDao {
	public abstract Online createAccount(Online bank);

	public abstract Online showBalance(Long accNo);

	

	public abstract Online getAccount(Long accNo);

}
