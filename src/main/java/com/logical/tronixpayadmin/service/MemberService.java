package com.logical.tronixpayadmin.service;

import org.springframework.http.ResponseEntity;

import com.logical.tronixpayadmin.entity.User;

public interface MemberService {

	ResponseEntity<?> getMembersList();

	ResponseEntity<?> getMemberById(Long userId);

	ResponseEntity<?> activeStatusByUserId(Long userId);

	ResponseEntity<?> updateMember(User user);

}
