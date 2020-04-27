package com.capg.service;

import java.util.List;

import com.capg.model.Online;
import com.capg.model.Transaction;

public interface OnlineService {

	public abstract Online createAccount(Online bank);

	public abstract Online showBalance(Long id);

	

	public abstract Online getAccount(Long accNo);

	
}
