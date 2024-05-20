package com.logical.tronixpayadmin.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.TrueFalseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.model.ExistingObjectReplication;
import com.logical.tronixpayadmin.entity.QRCodeDetails;
import com.logical.tronixpayadmin.model.response.GenericResponse;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.model.wrapper.QRCodeCashbackRequestWrapper;
import com.logical.tronixpayadmin.repository.QRCodeDetailsRepository;
import com.logical.tronixpayadmin.service.QRCodeDetailsService;

@Service
public class QRCodeDetailsServiceImpl implements QRCodeDetailsService {
    @Autowired
	QRCodeDetailsRepository qrCodeDetailsRepository;
	@Override
	public ResponseEntity<?> getCashbackRequestList() {
	
		List<QRCodeDetails> qrCodeCashbackRequestList = qrCodeDetailsRepository.findAllByRequestStatus(true);
		List<QRCodeCashbackRequestWrapper> wrappers = new ArrayList<>();

		for(QRCodeDetails qrCodeDetails : qrCodeCashbackRequestList) {
		    QRCodeCashbackRequestWrapper wrapper = new QRCodeCashbackRequestWrapper(qrCodeDetails);
		    wrappers.add(wrapper);
		}

	
	if (!qrCodeCashbackRequestList.isEmpty()) {
		return new ResponseEntity<>(new GenericResponse(true , "qrCodeCashbackRequestList get successfully" , wrappers), HttpStatus.OK);
		 
    } else { 
    	 return new ResponseEntity<>(new GenericResponse(true , "No QR Code cashback requests found." , wrappers) ,HttpStatus.OK);
   	   }
	}
	@Override
	public ResponseEntity<?> updateCashbackStatus(Long qrCodeDetailsId, boolean approveStatus) {
		
	           boolean isQRCodeExist = qrCodeDetailsRepository.existsById(qrCodeDetailsId);
	          if(isQRCodeExist) {
	        	    QRCodeDetails qrCodeDetails = qrCodeDetailsRepository.findById(qrCodeDetailsId).get();
	        	    qrCodeDetails.setApproveStatus(approveStatus);
	        	    qrCodeDetailsRepository.save(qrCodeDetails);
	        	    if (approveStatus) {
	        		 
		                return new ResponseEntity<>(new MessageResponse(true ,"Cashback approved for QR Code Successfully"),HttpStatus.OK);
		            } else {
		               return new ResponseEntity<>(new MessageResponse(true , "Cashback disapproved for QR Code Successfully"),HttpStatus.OK);
		            }  
	          }else {
	        	return new ResponseEntity<>(new MessageResponse(false , "QRCodeDetails not exist with this qrCodeDetailsId") , HttpStatus.NOT_FOUND)  ;
	          }
	           
	          
	        
	}

}
