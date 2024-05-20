package com.logical.tronixpayadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.logical.tronixpayadmin.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

	boolean existsByBankNameIgnoreCase(String bankName);

	
	
}
