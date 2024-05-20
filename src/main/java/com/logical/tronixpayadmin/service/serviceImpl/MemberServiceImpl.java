package com.logical.tronixpayadmin.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.logical.tronixpayadmin.entity.User;
import com.logical.tronixpayadmin.model.response.GenericResponse;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.model.wrapper.VendorWrapper;
import com.logical.tronixpayadmin.repository.UserRepository;
import com.logical.tronixpayadmin.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<?> getMembersList() {
		List<User> users = userRepository.findAll();

		return new ResponseEntity<>(new GenericResponse(true, "memberList  get Successfully", users), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> getMemberById(Long userId) {
		boolean isMemberExist = userRepository.existsById(userId);

		if (isMemberExist) {

			User user = userRepository.findById(userId).get();
			return new ResponseEntity<>(new GenericResponse(true, "member details  get Successfully", user),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new MessageResponse(false, "member deos not exist  with this user id"),
					HttpStatus.NOT_FOUND);

		}
	}

	// change status to active and inactive based on user id

	@Override
	public ResponseEntity<?> activeStatusByUserId(Long userId) {
		boolean isMemberExist = userRepository.existsById(userId);
		if (isMemberExist) {
			User user = userRepository.findById(userId).get();
			if (user.isActive()) {
				user.setActive(false);
				userRepository.save(user);
			} else {
				user.setActive(true);
				userRepository.save(user);

			}

			return new ResponseEntity<>(new MessageResponse(true, "status changed successfully"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new MessageResponse(false, "member deos not exist  with this user id"),
					HttpStatus.NOT_FOUND);

		}

	}

	//updateMemberData
	@Override
	public ResponseEntity<?> updateMember(User updateUserData) {
		return userRepository.findById(updateUserData.getUserId()).map(oldUserData -> {
			User user = updateUser(oldUserData, updateUserData);
			userRepository.save(user);
			return new ResponseEntity<>(new MessageResponse(true, "User data updated successfully"), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(new MessageResponse(false, "Member does not exist with this user ID"),
				HttpStatus.NOT_FOUND));

	}

	public User updateUser(User oldUserData, User newUserData) {
		
		if (newUserData.getAddress() != null) {
			oldUserData.setAddress(newUserData.getAddress());
		}
		if (newUserData.getAndroidFCMToken() != null) {
			oldUserData.setAndroidFCMToken(newUserData.getAndroidFCMToken());
		}
		if (newUserData.getDateOfJoin() != null) {
			oldUserData.setDateOfJoin(newUserData.getDateOfJoin());
		}
		if (newUserData.getEmail() != null) {
			oldUserData.setEmail(newUserData.getEmail());
		}
		if (newUserData.getIOSFCMToken() != null) {
			oldUserData.setIOSFCMToken(newUserData.getIOSFCMToken());
		}
		if (newUserData.getLatitude() != null) {
			oldUserData.setLatitude(newUserData.getLatitude());
		}
		if (newUserData.getLongitude() != null) {
			oldUserData.setLongitude(newUserData.getLongitude());
		}
		if (newUserData.getMemberId() != null) {
			oldUserData.setMemberId(newUserData.getMemberId());
		}
		if (newUserData.getMobileNumber() != null) {
			oldUserData.setMobileNumber(newUserData.getMobileNumber());
		}
		if (newUserData.getProfileImageUrl() != null) {
			oldUserData.setProfileImageUrl(newUserData.getProfileImageUrl());
		}
		if (newUserData.getReactFCMToken() != null) {
			oldUserData.setReactFCMToken(newUserData.getReactFCMToken());
		}
		if (newUserData.getReferralId() != null) {
			oldUserData.setReferralId(newUserData.getReferralId());
		}
		if (newUserData.getUserName() != null) {
			oldUserData.setUserName(newUserData.getUserName());
		}
		return oldUserData;
	}

}
