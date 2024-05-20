package com.logical.tronixpayadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/admin/QRCode")
public interface QRCodeDetailsController {

	
	@GetMapping("/getCashbaskRequestList")
    public ResponseEntity<?> getCashbackRequestList();
	
	@PostMapping("/updateCashbackStatus")
	public ResponseEntity<?> updateCashbackStatus(
	            @RequestParam Long qrCodeDetailsId,
	            @RequestParam boolean approveStatus
	    );   
	
}
