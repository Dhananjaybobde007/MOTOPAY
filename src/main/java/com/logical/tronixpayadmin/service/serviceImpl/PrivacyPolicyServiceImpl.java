package com.logical.tronixpayadmin.service.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.logical.tronixpayadmin.businessServices.DateUtilsService;
import com.logical.tronixpayadmin.entity.PrivacyPolicy;
import com.logical.tronixpayadmin.model.response.GenericResponse;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.repository.PrivacyPolicyRepository;
import com.logical.tronixpayadmin.service.PrivacyPolicyService;
@Service
public class PrivacyPolicyServiceImpl implements PrivacyPolicyService {

	@Autowired
	DateUtilsService dateUtilsService;
	@Autowired
	PrivacyPolicyRepository privacyPolicyRepository;
	@Override
	public ResponseEntity<?> createPrivacyPolicy(PrivacyPolicy privacyPolicy) {
		LocalDate localDate  = dateUtilsService.getLocalDate();
		
		List<PrivacyPolicy> newPrivacyPolicy = privacyPolicyRepository.findAll();
		if(privacyPolicy.getTitle() == null)privacyPolicy.setTitle("");
		if(privacyPolicy.getDescription() == null)privacyPolicy.setDescription("");
		
		if(newPrivacyPolicy.isEmpty()) {
			privacyPolicy.setDateOfCreation(localDate);
			privacyPolicyRepository.save(privacyPolicy);
			return new ResponseEntity<>(new MessageResponse(true , "privacy policy created Successfully") , HttpStatus.OK);
			
		}
		else {
			PrivacyPolicy oldPrivacyPolicy =newPrivacyPolicy.get(0);
			oldPrivacyPolicy.setDateOfCreation(localDate);
			oldPrivacyPolicy.setTitle(privacyPolicy.getTitle());
			oldPrivacyPolicy.setDescription(privacyPolicy.getDescription());
			privacyPolicyRepository.save(oldPrivacyPolicy);
			
			return new ResponseEntity<>(new MessageResponse(true , "privacy policy Updated Successfully") , HttpStatus.OK);
			
		}
		
		
	}
	@Override
	public ResponseEntity<?> getPrivacyPolicy() {
		 List<PrivacyPolicy> privacyPolicies = privacyPolicyRepository.findAll();
		    
		    if (privacyPolicies.isEmpty()) {
		        return new ResponseEntity<>("No privacy policies found", HttpStatus.NOT_FOUND);
		    }
		    
		    // Create a list to hold only the first element
		    List<PrivacyPolicy> firstPrivacyPolicy = new ArrayList<>();
		    firstPrivacyPolicy.add(privacyPolicies.get(0));
		    
		    return new ResponseEntity<>(new GenericResponse(true , "privacy policy get Successfully",firstPrivacyPolicy ) , HttpStatus.OK);
			
	}



}
