package com.logical.tronixpayadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("admin/api")
public interface UserController {
      
	@PostMapping("/update")
    public ResponseEntity<?> updateAdminProfile(@RequestParam("adminId") int adminId,
                                     @RequestParam("bio") String bio,
                                     @RequestParam("name") String name,
                                     @RequestParam(value = "profileImg" , required = false) MultipartFile profileImg);
    
}
