package com.logical.tronixpayadmin.controller.controllerImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.logical.tronixpayadmin.controller.VendorController;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.service.VendorService;
@RestController
public class VendorControllerImpl implements VendorController {
	 private Logger logger  = LoggerFactory.getLogger(VendorControllerImpl.class);
	    
	@Autowired
	VendorService vendorService;
	@Override
	public ResponseEntity<?> getVendorsList() {
		try {
			return vendorService.getVendorsList();
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
	public ResponseEntity<?> getVendorById(Long vendorId) {
		try {
			return vendorService.getVendorById(vendorId);
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
