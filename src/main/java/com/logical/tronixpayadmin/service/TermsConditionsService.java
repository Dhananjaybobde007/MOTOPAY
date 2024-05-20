package com.logical.tronixpayadmin.service;

import org.springframework.http.ResponseEntity;

import com.logical.tronixpayadmin.entity.TermsConditions;

public interface TermsConditionsService {

	ResponseEntity<?> createTermsConditions(TermsConditions termsConditions);

	ResponseEntity<?> getTermsConditions();

	

}
