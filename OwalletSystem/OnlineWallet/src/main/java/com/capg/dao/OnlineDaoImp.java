package com.capg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.model.Online;
import com.capg.model.Transaction;
@Repository
public class OnlineDaoImp implements OnlineDao {

	@Autowired
	OnlineRepo brepo;
	@Autowired
	TransactionRepo trepo;

	@Override
	public Online createAccount(Online bank) {

		  Transaction tran = new Transaction(); tran.setBalance(bank.getBalance());
		  tran.setCreditedAmount(bank.getBalance());
		  tran.setTransactionId((long)(Math.random()*1000));
		  tran.setDebitedAmount((double) 0); tran.setAccNo(bank.getAccNo()); trepo.save(tran);
		 
		 
		return brepo.save(bank);
	}

	@Override
	public Online showBalance(Long accNo)
	{

		return brepo.findByAccNo(accNo);
		
	}


	@Override
	public Online getAccount(Long accNo) 
	{
	
		return brepo.findByAccNo(accNo);
	}

	


	
	

	
}
