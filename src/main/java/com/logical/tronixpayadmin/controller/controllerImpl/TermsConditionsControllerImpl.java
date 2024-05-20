package com.logical.tronixpayadmin.controller.controllerImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.logical.tronixpayadmin.controller.TermsConditionsController;
import com.logical.tronixpayadmin.entity.TermsConditions;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.service.TermsConditionsService;

@RestController
public class TermsConditionsControllerImpl implements TermsConditionsController {
	private Logger logger  = LoggerFactory.getLogger(TermsConditionsControllerImpl.class);
	  
	@Autowired
	TermsConditionsService termsConditionsService;
	@Override
	public ResponseEntity<?> createTermsConditions(TermsConditions termsConditions) {
		try {
			return termsConditionsService.createTermsConditions(termsConditions);
		} 
	       catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@Override
	public ResponseEntity<?> getTermsConditions() {
		try {
			return termsConditionsService.getTermsConditions();
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
