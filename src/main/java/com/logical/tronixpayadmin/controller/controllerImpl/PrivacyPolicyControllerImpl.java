package com.logical.tronixpayadmin.controller.controllerImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.logical.tronixpayadmin.controller.PrivacyPolicyController;
import com.logical.tronixpayadmin.entity.PrivacyPolicy;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.service.PrivacyPolicyService;
@RestController
public class PrivacyPolicyControllerImpl implements PrivacyPolicyController {

	private Logger logger  = LoggerFactory.getLogger(PrivacyPolicyControllerImpl.class);
	  
	@Autowired
	PrivacyPolicyService privacyPolicyService;
	@Override
	public ResponseEntity<?> createPrivacyPolicy(PrivacyPolicy privacyPolicy) {
		try {
			return privacyPolicyService.createPrivacyPolicy(privacyPolicy);
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
	public ResponseEntity<?> getPrivacyPolicy() {
		try {
			return privacyPolicyService.getPrivacyPolicy();
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
