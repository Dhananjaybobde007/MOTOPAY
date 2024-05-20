package com.logical.tronixpayadmin.service;

import org.springframework.http.ResponseEntity;

import com.logical.tronixpayadmin.entity.PrivacyPolicy;

public interface PrivacyPolicyService {

	ResponseEntity<?> createPrivacyPolicy(PrivacyPolicy privacyPolicy);

	ResponseEntity<?> getPrivacyPolicy();

}
