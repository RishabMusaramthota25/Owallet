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
	public Online deposite(Long accNo, Double depositeAmount) {
		
		
		
		Online bank= brepo.findByAccNo(accNo);
		Double currentBal= bank.getBalance();
		Transaction tran=new Transaction();
		tran.setTransactionId((long)(Math.random()*1000));
		tran.setCreditedAmount(depositeAmount);
		tran.setDebitedAmount((double)0);
		tran.setBalance(currentBal+depositeAmount);
		tran.setAccNo(accNo);
		trepo.save(tran);
		bank.setBalance(currentBal+depositeAmount);
		return brepo.save(bank);
	}

	@Override
	public Online getAccount(Long accNo) 
	{
	
		return brepo.findByAccNo(accNo);
	}

	
	@Override
	public Online withdraw(Long accNo, Double withdrawAmount) {

		Online bank = brepo.findByAccNo(accNo);
		Transaction tran = new Transaction();
		tran.setTransactionId((long)(Math.random()*1000));
		tran.setAccNo(accNo);
		tran.setDebitedAmount(withdrawAmount);
		tran.setCreditedAmount((double)0);
		Double currentBal = bank.getBalance();
		tran.setBalance(currentBal-withdrawAmount);
		bank.setBalance(currentBal-withdrawAmount);
		trepo.save(tran);
		return brepo.save(bank);
	}

	
	
	  @Override public List<Transaction> printTransactions(Long accNo) 
	  {
		  
	  return trepo.findAllByAccNo(accNo);
	  }
	 

	@Override
	public Online fundTransfer(Long saccNo, Long raccNo, Double transferAmount) {
		
		Online sBank=withdraw(saccNo, transferAmount);
		deposite(raccNo, transferAmount);
		
		return sBank;
	}

	
}
