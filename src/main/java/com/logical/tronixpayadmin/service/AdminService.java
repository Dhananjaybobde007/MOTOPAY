package com.logical.tronixpayadmin.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.logical.tronixpayadmin.model.SignUpRequest;

public interface AdminService {

	 public ResponseEntity<?> adminSignUp(SignUpRequest signUpRequest);
	 
	 public ResponseEntity<?> checkAdminEmailAndPassword(String email , String password);

	public ResponseEntity<?> logOutUser(int adminId);

}
