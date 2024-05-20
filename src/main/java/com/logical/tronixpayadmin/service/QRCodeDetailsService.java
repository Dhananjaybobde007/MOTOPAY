package com.logical.tronixpayadmin.service;

import org.springframework.http.ResponseEntity;

public interface QRCodeDetailsService {

	public ResponseEntity<?> getCashbackRequestList();

	public ResponseEntity<?> updateCashbackStatus(Long qrCodeDetailsId, boolean approveStatus);

}
