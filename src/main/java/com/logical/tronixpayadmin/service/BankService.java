package com.logical.tronixpayadmin.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface BankService {

	public ResponseEntity<?> createBank(String bankName, MultipartFile imageUrl);

	public ResponseEntity<?> getBanksList();

	public ResponseEntity<?> updateBank(Long bankId, String bankName, MultipartFile imageUrl);

	public ResponseEntity<?> getBankById(Long bankId);
}
