package com.logical.tronixpayadmin.service.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.logical.tronixpayadmin.businessServices.DateUtilsService;
import com.logical.tronixpayadmin.entity.RefundPolicy;
import com.logical.tronixpayadmin.model.response.GenericResponse;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.repository.RefundPolicyRepository;
import com.logical.tronixpayadmin.service.RefundPolicyService;

@Service
public class RefundPolicyServiceImpl implements RefundPolicyService {

	@Autowired
	DateUtilsService dateUtilsService;
	@Autowired
	RefundPolicyRepository refundPolicyRepository;
	@Override
	public ResponseEntity<?> createRefundPolicy(RefundPolicy refundPolicy) {
		LocalDate localDate  = dateUtilsService.getLocalDate();
		
		List<RefundPolicy> newRefundPolicy = refundPolicyRepository.findAll();
		if(refundPolicy.getTitle() == null)refundPolicy.setTitle("");
		if(refundPolicy.getDescription() == null)refundPolicy.setDescription("");
		
		if(newRefundPolicy.isEmpty()) {
			refundPolicy.setDateOfCreation(localDate);
			refundPolicyRepository.save(refundPolicy);
			return new ResponseEntity<>(new MessageResponse(true , "refund policy created Successfully") , HttpStatus.OK);
			
		}
		else {
			RefundPolicy oldRefundPolicy =newRefundPolicy.get(0);
			oldRefundPolicy.setDateOfCreation(localDate);
			oldRefundPolicy.setTitle(refundPolicy.getTitle());
			oldRefundPolicy.setDescription(refundPolicy.getDescription());
			refundPolicyRepository.save(oldRefundPolicy);
			
			return new ResponseEntity<>(new MessageResponse(true , "refund policy Updated Successfully") , HttpStatus.OK);
			
		}
		
	}
	@Override
	public ResponseEntity<?> getRefundPolicy() {
		 List<RefundPolicy> refundPolicies = refundPolicyRepository.findAll();
		    
		    if (refundPolicies.isEmpty()) {
		        return new ResponseEntity<>("No refund policies found", HttpStatus.NOT_FOUND);
		    }
		    
		    // Create a list to hold only the first element
		    List<RefundPolicy> firstRefundPolicy = new ArrayList<>();
		    firstRefundPolicy.add(refundPolicies.get(0));
		    
		    return new ResponseEntity<>(new GenericResponse(true, "Refund policy retrieved successfully", firstRefundPolicy), HttpStatus.OK);

	}

}
