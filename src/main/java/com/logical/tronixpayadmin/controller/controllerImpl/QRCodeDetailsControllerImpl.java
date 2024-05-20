package com.logical.tronixpayadmin.controller.controllerImpl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.logical.tronixpayadmin.controller.QRCodeDetailsController;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.service.QRCodeDetailsService;

@RestController
public class QRCodeDetailsControllerImpl implements QRCodeDetailsController {

	private Logger logger = LoggerFactory.getLogger(QRCodeDetailsControllerImpl.class);
	@Autowired 
	QRCodeDetailsService qRCodeDetailsService;
	@Override
	public ResponseEntity<?> getCashbackRequestList() {
		try {
			return qRCodeDetailsService.getCashbackRequestList();
		} 
	       catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@Override
	public ResponseEntity<?> updateCashbackStatus(Long qrCodeDetailsId, boolean approveStatus) {
		try {
			return qRCodeDetailsService.updateCashbackStatus(qrCodeDetailsId ,approveStatus);
		} 
	       catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
