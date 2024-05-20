package com.logical.tronixpayadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/transaction-history")
public interface TransactionController {

	
	 @GetMapping("/get")
	    public ResponseEntity<?> getTransactionHistory();
}
