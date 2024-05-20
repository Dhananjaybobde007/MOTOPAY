package com.logical.tronixpayadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/admin/banks")
public interface BankController {

	@PostMapping(value = "/create") // consumes = {"multipart/form-data"}
	ResponseEntity<?> createBank(@RequestParam(value = "bankName", required = false) String bankName,
			@RequestParam(value = "imageUrl", required = false) MultipartFile imageUrl);

	@GetMapping("getList")
	public ResponseEntity<?> getBanksList();

	@PostMapping(value = "/update")
	ResponseEntity<?> updateBank(@RequestParam(value = "bankId", required = true) Long bankId,
			@RequestParam(value = "bankName", required = true) String bankName,
			@RequestParam(value = "imageUrl", required = false) MultipartFile imageUrl);

	 @GetMapping("/getBankById/{bankId}")
	    public ResponseEntity<?> getBankById(@PathVariable Long bankId);
	 
}
