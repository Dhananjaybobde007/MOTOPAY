package com.logical.tronixpayadmin.controller.controllerImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.logical.tronixpayadmin.controller.TransactionController;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.service.TransactionService;

@RestController
public class TransactionControllerImpl implements TransactionController {
    
	private Logger logger = LoggerFactory.getLogger(TransactionControllerImpl.class);
	
	
	@Autowired
	TransactionService transactionService;
	@Override
	public ResponseEntity<?> getTransactionHistory() {
		try {
			return transactionService.getTransactionHistory();
		} 
	       catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
