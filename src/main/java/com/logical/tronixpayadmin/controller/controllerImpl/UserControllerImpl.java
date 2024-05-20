package com.logical.tronixpayadmin.controller.controllerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.logical.tronixpayadmin.controller.UserController;
import com.logical.tronixpayadmin.service.UserService;

@RestController
public class UserControllerImpl implements UserController {

	@Autowired
	UserService userService;
	@Override
	public ResponseEntity<?> updateAdminProfile(int adminId, String bio, String name ,  MultipartFile profileImg)  {
        return userService.updateAdminProfile(adminId , bio, name, profileImg);
    }    

}
