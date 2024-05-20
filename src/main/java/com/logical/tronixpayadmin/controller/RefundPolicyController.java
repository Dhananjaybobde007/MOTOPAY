package com.logical.tronixpayadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logical.tronixpayadmin.entity.RefundPolicy;
@RequestMapping("/admin/refund-policy")
public interface RefundPolicyController {

	@PostMapping("/create")
	public ResponseEntity<?> createRefundPolicy(@RequestBody RefundPolicy refundPolicy);

	 @GetMapping("/get")
	    public ResponseEntity<?> getRefundPolicy();
}
