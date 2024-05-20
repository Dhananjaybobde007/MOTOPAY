package com.logical.tronixpayadmin.service.serviceImpl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.logical.tronixpayadmin.entity.Admin;
import com.logical.tronixpayadmin.model.SignUpRequest;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.model.response.SignInResponse;
import com.logical.tronixpayadmin.repository.AdminRepository;
import com.logical.tronixpayadmin.security.jwt.JwtUtils;
import com.logical.tronixpayadmin.service.AdminService;
import com.logical.tronixpayadmin.service.StorageService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public ResponseEntity<?> adminSignUp(SignUpRequest signUpRequest) {
		 if (adminRepository.existsByEmail(signUpRequest.getEmail().toLowerCase())) {
	            return new ResponseEntity<>(new MessageResponse(false, "Email is already in use!"), HttpStatus.IM_USED);
	        }
	        Admin adminData = new Admin();
	        adminData.setAdminName(signUpRequest.getAdminName());
	        adminData.setEmail(signUpRequest.getEmail().toLowerCase());
	        adminData.setAdminBio("Admin");
	        adminData.setProfileImgUrl("");
	        System.out.println(signUpRequest.getPassword());
	        adminData.setPassword(this.passwordEncoder.encode(signUpRequest.getPassword()));
	        adminData.setRole("ADMIN");
	        adminRepository.save(adminData);
	        return new ResponseEntity<>(new MessageResponse(true, "Admin registered successfully!"), HttpStatus.CREATED);
	}
	
	
	@Override
	public ResponseEntity<?> checkAdminEmailAndPassword(String email, String password) {
		Admin admin = adminRepository.findByEmail(email);
	        if (admin == null) {
	            return new ResponseEntity<>(
	                    new MessageResponse(false, "Admin email not found"),
	                    HttpStatus.NOT_FOUND);
	        }
	        // Compare  pwd with the hashed pwd stored in db
	        if (passwordEncoder.matches(password, admin.getPassword())) {
	            
	        	String credentials = email + ":" + password;
	        	String basicAuthToken =  "Basic "+ Base64.getEncoder().encodeToString(credentials.getBytes());
	        	System.out.println("Authorization: " + basicAuthToken);
	        	
	        	return new ResponseEntity<>(
	                    new SignInResponse(true, "Admin login successfully" , admin.getAdminId(),email,password ,admin.getProfileImgUrl() ,  basicAuthToken),
	                    HttpStatus.OK);
	        } else {
	            // Passwords don't match
	            return new ResponseEntity<>(
	                    new MessageResponse(false, "Invalid admin password"),
	                    HttpStatus.UNAUTHORIZED);
	        }
		  
	}


	 @Override
	    public ResponseEntity<?> logOutUser(int adminId) {
	        if (adminId > 0) {
	            if (adminRepository.existsById(adminId)) {
	                // Clear the authentication context
	                SecurityContextHolder.clearContext();

	                // Clean up JWT token cookie
	                ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
	                
	                // Return response with cleared cookie
	                return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
	                        .body(new MessageResponse(true, "You've been signed out!"));
	            } else {
	                return new ResponseEntity<>(new MessageResponse(false, "Admin does not exist with this adminId!"), HttpStatus.NOT_FOUND);
	            }
	        } else {
	            return new ResponseEntity<>(new MessageResponse(false, "Please provide a valid adminId!"), HttpStatus.BAD_REQUEST);
	        }
	    }


	
	 
	
}
