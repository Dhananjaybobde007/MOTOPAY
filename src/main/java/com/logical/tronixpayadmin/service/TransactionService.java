package com.logical.tronixpayadmin.service;

import org.springframework.http.ResponseEntity;

public interface TransactionService {

	ResponseEntity<?> getTransactionHistory();

}
