package com.logical.tronixpayadmin.controller.controllerImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.logical.tronixpayadmin.controller.MemberController;
import com.logical.tronixpayadmin.entity.User;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.service.MemberService;

@RestController
public class MemberControllerImpl implements MemberController {

	private Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);

	@Autowired
	MemberService memberService;

	@Override
	public ResponseEntity<?> getMembersList() {
		try {
			return memberService.getMembersList();
		} catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> getMemberById(Long userId) {
		try {
			return memberService.getMemberById(userId);
		} catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> activeStatusByUserId(Long userId) {
		try {
			return memberService.activeStatusByUserId(userId);
		} catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<?> updateMember(User user) {

		try {
			return memberService.updateMember(user);
		} catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
