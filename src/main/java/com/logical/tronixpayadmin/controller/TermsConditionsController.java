package com.logical.tronixpayadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logical.tronixpayadmin.entity.TermsConditions;
@RequestMapping("/admin/terms-conditions")
public interface TermsConditionsController {

	@PostMapping("/create")
	public ResponseEntity<?> createTermsConditions(@RequestBody TermsConditions TermsConditions);

	 @GetMapping("/get")
	    public ResponseEntity<?> getTermsConditions();
}
