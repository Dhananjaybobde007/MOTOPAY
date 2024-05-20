package com.logical.tronixpayadmin.service;

import org.springframework.http.ResponseEntity;

import com.logical.tronixpayadmin.entity.RefundPolicy;

public interface RefundPolicyService {

	ResponseEntity<?> createRefundPolicy(RefundPolicy refundPolicy);

	ResponseEntity<?> getRefundPolicy();

}
