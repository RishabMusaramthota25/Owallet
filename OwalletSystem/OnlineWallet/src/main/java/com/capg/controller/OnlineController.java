package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Online;
import com.capg.model.Transaction;

import com.capg.service.OnlineService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OnlineController {

	@Autowired
	private OnlineService service;
	
	
	@PostMapping(path="/create")
	public Online createAccount(@RequestBody Online bank)
	{
		return service.createAccount(bank);
	}

	@GetMapping(path="/show/{id}")
	public Online showBalance(@PathVariable Long id)
	{
		return service.showBalance(id);
	}
	
	
	
	
	
	@GetMapping(path="/get/{accNo}")
	public Online getAccount(@PathVariable Long accNo) 
	
	{
		return service.getAccount(accNo);
	}
	
	
	
	/**/
}