package com.logical.tronixpayadmin.model.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.logical.tronixpayadmin.entity.Admin;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminWrapper {

	 @JsonProperty("adminId")
	    private int adminId; 
	 @JsonProperty("adminName")
	    private String adminName; 
	 @JsonProperty("email")
	    private String email; 
	 @JsonProperty("adminBio")
	    private String adminBio; 
	 @JsonProperty("profileImgUrl")
	    private String profileImgUrl; 
	
	 public AdminWrapper(Admin admin) {
		 this.adminId = admin.getAdminId();
		 this.adminName = admin.getAdminName();
		 this.adminBio = admin.getAdminBio();
		 this.email = admin.getEmail();
		 this.profileImgUrl = admin.getProfileImgUrl();
	 }
	 
}
