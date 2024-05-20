package com.logical.tronixpayadmin.service.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.logical.tronixpayadmin.businessServices.DateUtilsService;
import com.logical.tronixpayadmin.entity.TermsConditions;
import com.logical.tronixpayadmin.model.response.GenericResponse;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.repository.TermsConditionsRepository;
import com.logical.tronixpayadmin.service.TermsConditionsService;
@Service
public class TermsConditionsServiceImpl implements TermsConditionsService {
	@Autowired
	DateUtilsService dateUtilsService;
	@Autowired
	TermsConditionsRepository termsConditionsRepository;
	@Override
	public ResponseEntity<?> createTermsConditions(TermsConditions termsConditions) {
		
		List<TermsConditions> newTermsConditions = termsConditionsRepository.findAll();
		LocalDate localDate  = dateUtilsService.getLocalDate();
		if(termsConditions.getTitle() == null)termsConditions.setTitle("");
		if(termsConditions.getDescription() == null)termsConditions.setDescription("");
		
		
		if(newTermsConditions.isEmpty()) {
			termsConditions.setDateOfCreation(localDate);
			termsConditionsRepository.save(termsConditions);
			return new ResponseEntity<>(new MessageResponse(true , "terms conditions created Successfully") , HttpStatus.OK);
			
		}
		else {
			TermsConditions oldTermsConditions =newTermsConditions.get(0);
			oldTermsConditions.setDateOfCreation(localDate);
			oldTermsConditions.setTitle(termsConditions.getTitle());
			oldTermsConditions.setDescription(termsConditions.getDescription());
			termsConditionsRepository.save(oldTermsConditions);
			
			return new ResponseEntity<>(new MessageResponse(true , "Terms Conditions Updated Successfully") , HttpStatus.OK);
			
		}
		
		
		
	}
	@Override
	public ResponseEntity<?> getTermsConditions() {
		 List<TermsConditions> termsConditionsList = termsConditionsRepository.findAll();
		    
		    if (termsConditionsList.isEmpty()) {
		        return new ResponseEntity<>("No terms and conditions found", HttpStatus.NOT_FOUND);
		    }
		    
		    // Create a list to hold only the first element
		    List<TermsConditions> firstTermsConditions = new ArrayList<>();
		    firstTermsConditions.add(termsConditionsList.get(0));
		    
		    return new ResponseEntity<>(new GenericResponse(true, "Terms and conditions retrieved successfully", firstTermsConditions), HttpStatus.OK);

	}
	
	

}
