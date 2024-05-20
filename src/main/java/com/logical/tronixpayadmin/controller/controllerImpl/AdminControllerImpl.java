package com.logical.tronixpayadmin.controller.controllerImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.logical.tronixpayadmin.controller.AdminController;
import com.logical.tronixpayadmin.model.SignUpRequest;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.service.AdminService;

@RestController
public class AdminControllerImpl implements AdminController{

	private Logger logger = LoggerFactory.getLogger(AdminControllerImpl.class);
	
	
	@Autowired
	AdminService adminService;
	
	@Override
	public ResponseEntity<?> adminSignUp(SignUpRequest signUpRequest) {
		try {
			return adminService.adminSignUp(signUpRequest );
		} catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	@Override
	public ResponseEntity<?> checkAdminEmailAndPassword(String email, String password) {
			try {
			return adminService.checkAdminEmailAndPassword(email ,password );
		} catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}



	@Override
	public ResponseEntity<?> logOutUser(int adminId) {
		try {
			return adminService.logOutUser(adminId);
		} catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	
	
}
