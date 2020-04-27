package com.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.Online;

public interface OnlineRepo extends JpaRepository<Online, Integer> {

	Online findByAccNo(Long accNo);
}
