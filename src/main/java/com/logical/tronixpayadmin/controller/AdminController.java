package com.logical.tronixpayadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.logical.tronixpayadmin.model.SignUpRequest;

@RequestMapping("/tronix-admin")
public interface AdminController {

	 @PostMapping("/adminSignUp")
	    public ResponseEntity<?> adminSignUp(@RequestBody SignUpRequest signUpRequest) ;
	
	 @PostMapping("/loginProcess")
	    public ResponseEntity<?> checkAdminEmailAndPassword(@RequestParam("email") String email,
	                               @RequestParam("password") String password
	                              ) ;
	
	 @PostMapping("/signOut")
	 	public ResponseEntity<?> logOutUser(
			@RequestParam(name = "adminId", required = true, defaultValue = "0") int adminId);

	 
}
