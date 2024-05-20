package com.logical.tronixpayadmin.service;

import org.springframework.http.ResponseEntity;

public interface VendorService {

	ResponseEntity<?> getVendorsList();

	ResponseEntity<?> getVendorById(Long vendorId);

	
}
