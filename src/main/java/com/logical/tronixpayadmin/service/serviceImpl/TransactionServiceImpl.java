package com.logical.tronixpayadmin.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.logical.tronixpayadmin.businessServices.DateUtilsService;
import com.logical.tronixpayadmin.entity.Transaction;
import com.logical.tronixpayadmin.model.response.GenericResponse;
import com.logical.tronixpayadmin.model.wrapper.TransactionWrapper;
import com.logical.tronixpayadmin.repository.TransactionRepository;
import com.logical.tronixpayadmin.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	@Override
	public ResponseEntity<?> getTransactionHistory() {
		List<Transaction> transactionHistoryList = transactionRepository.findAll();
		List<TransactionWrapper> transactionWrapperList = new ArrayList<>();
		
		
		DateUtilsService dateUtilsService = new DateUtilsService();
			
		for(Transaction transaction : transactionHistoryList) {
			//convert localdatetime to stringformat
			String dateTime =  dateUtilsService.getLocalDateTimeToString(transaction.getTransactionDateTime()) ;
		
			TransactionWrapper transactionWrapper = new TransactionWrapper(transaction , dateTime);
			transactionWrapperList.add(transactionWrapper);
		}
		
		return new ResponseEntity<>(new GenericResponse(true , "transaction history retrieved successfully" , transactionWrapperList) , HttpStatus.OK ); 

		
		}

}
