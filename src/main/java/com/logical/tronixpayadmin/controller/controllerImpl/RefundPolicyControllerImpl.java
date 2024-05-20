package com.logical.tronixpayadmin.controller.controllerImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.logical.tronixpayadmin.controller.RefundPolicyController;
import com.logical.tronixpayadmin.entity.RefundPolicy;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.service.RefundPolicyService;
@RestController
public class RefundPolicyControllerImpl implements RefundPolicyController {
	private Logger logger  = LoggerFactory.getLogger(RefundPolicyControllerImpl.class);
	  
	@Autowired
	RefundPolicyService refundPolicyService;
	@Override
	public ResponseEntity<?> createRefundPolicy(RefundPolicy refundPolicy) {
		try {
			return refundPolicyService.createRefundPolicy(refundPolicy);
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
	public ResponseEntity<?> getRefundPolicy() {
		try {
			return refundPolicyService.getRefundPolicy();
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
