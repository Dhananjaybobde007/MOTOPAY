package com.logical.tronixpayadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logical.tronixpayadmin.entity.PrivacyPolicy;

@RequestMapping("/admin/privacy-policy")
public interface PrivacyPolicyController {

	@PostMapping("/create")
	public ResponseEntity<?> createPrivacyPolicy(@RequestBody PrivacyPolicy privacyPolicy);

	 @GetMapping("/get")
	    public ResponseEntity<?> getPrivacyPolicy();
	 
}
