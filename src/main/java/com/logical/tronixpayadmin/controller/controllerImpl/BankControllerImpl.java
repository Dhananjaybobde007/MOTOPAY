package com.logical.tronixpayadmin.controller.controllerImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.logical.tronixpayadmin.controller.BankController;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.service.BankService;

@RestController
public class BankControllerImpl implements BankController {
    private Logger logger  = LoggerFactory.getLogger(BankControllerImpl.class);
    
    @Autowired
    BankService bankService;
	@Override
	public ResponseEntity<?> createBank(String bankName, MultipartFile imageUrl) {
		try {
			 if ((bankName == null || bankName.isEmpty()) || (imageUrl == null || imageUrl.isEmpty())) {
		            return new ResponseEntity<>("Both bankName and imageUrl are required", HttpStatus.BAD_REQUEST);
		        }
			 
			return bankService.createBank(bankName, imageUrl);
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
	public ResponseEntity<?> getBanksList() {
		try { 
			return bankService.getBanksList();
		} catch (Exception e) {
			logger.info(" " + e);
			e.printStackTrace();
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> updateBank(Long bankId, String bankName, MultipartFile imageUrl) {
		try { 
			return bankService.updateBank(bankId ,bankName , imageUrl);
		} catch (Exception e) {
			logger.info(" " + e);
			e.printStackTrace();
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> getBankById(Long bankId) {
			try {
				return bankService.getBankById(bankId);
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
