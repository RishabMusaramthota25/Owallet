package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.OnlineDao;
import com.capg.model.Online;
import com.capg.model.Transaction;

@Service
public class OnlineServiceImp implements OnlineService{

	@Autowired
	private OnlineDao dao;
	
	@Override
	public Online createAccount(Online bank) {
		
		return dao.createAccount(bank);
	}

	@Override
	public Online showBalance(Long accNo) {
	
		return dao.showBalance(accNo);
	}

	

	@Override
	public Online getAccount(Long accNo)
	{
		
		return dao.getAccount(accNo);
	}
	



	
}
