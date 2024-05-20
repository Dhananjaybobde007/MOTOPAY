package com.logical.tronixpayadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/vendor")
public interface VendorController {
      
	@GetMapping("/getList")
	public ResponseEntity<?> getVendorsList();
	
	 @GetMapping("/getVendorById/{vendorId}")
	    public ResponseEntity<?> getVendorById(@PathVariable Long vendorId);
	 
}
