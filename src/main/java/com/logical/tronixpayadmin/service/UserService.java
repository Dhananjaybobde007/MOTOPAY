package com.logical.tronixpayadmin.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {


	public ResponseEntity<?> updateAdminProfile(int adminId,  String bio, String name ,MultipartFile profileImg);

	
}
