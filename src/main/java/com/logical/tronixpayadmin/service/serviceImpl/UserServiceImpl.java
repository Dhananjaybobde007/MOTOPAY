package com.logical.tronixpayadmin.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.logical.tronixpayadmin.entity.Admin;
import com.logical.tronixpayadmin.model.response.GenericResponse;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.model.wrapper.AdminWrapper;
import com.logical.tronixpayadmin.repository.AdminRepository;
import com.logical.tronixpayadmin.service.StorageService;
import com.logical.tronixpayadmin.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	StorageService fileService;
    @Value("${project.image}")
    String path;
    @Autowired 
    AdminRepository adminRepository;
    
	@Override
	public ResponseEntity<?> updateAdminProfile(int adminId, String bio, String name, MultipartFile profileImg) {
	
        if (adminId > 0) {
            if (adminRepository.existsById(adminId)) {
                Admin adminData = adminRepository.findById(adminId).get();
                if (name.isBlank() || name.isEmpty() || name == null) {
                    adminData.setAdminName(adminData.getAdminName());
                } else {
                    adminData.setAdminName(name);
                }

                if (bio.isBlank() || bio.isEmpty() || bio == null) {
                    adminData.setAdminBio(adminData.getAdminBio());
                } else {
                    adminData.setAdminBio(bio);
                }

                if (profileImg != null && !profileImg.isEmpty()) { 
    				
    				String adminImg = adminData.getProfileImgUrl();
    				if (adminImg != null || !adminImg.isEmpty()) {
    					fileService.deleteImageFile(adminImg);
    				}
    				//upload update image
    				String url = fileService.uploadFile(path, profileImg);
    			    String[] parts = url.split("/");
    			    String filename = parts[parts.length - 1];
    			    adminData.setProfileImgUrl(filename);
    			   
    			    System.out.println("new image name="+ adminData.getProfileImgUrl());	
    				
    			}
                adminRepository.save(adminData);
                AdminWrapper adminWrapper = new AdminWrapper(adminData);
                return new ResponseEntity<>(new GenericResponse(true, "admin updated successfully" ,adminWrapper), HttpStatus.OK);
            } 
            else {
                return new ResponseEntity<>(new MessageResponse(false, "admin does not exist with this adminId !"), HttpStatus.NOT_FOUND);
            }
        } 
        else {
            return new ResponseEntity<>(new MessageResponse(false, "Please provide valid adminId !"), HttpStatus.NOT_ACCEPTABLE);
        }
        
	}

	
}
