package com.logical.tronixpayadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logical.tronixpayadmin.entity.User;

@RequestMapping("/admin/member")
public interface MemberController {

	@GetMapping("/getList")
	public ResponseEntity<?> getMembersList();
	
	 @GetMapping("/getMemberById/{userId}")
	    public ResponseEntity<?> getMemberById(@PathVariable Long userId);
	 
	 @PostMapping("/activeStatusByUserId/{userId}")
	 public ResponseEntity<?> activeStatusByUserId(@PathVariable Long userId);
		 
	 @PutMapping("/updateMember")
	 public ResponseEntity<?> updateMember(@RequestBody User user);
	 
}
