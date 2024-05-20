package com.logical.tronixpayadmin.entity;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.Index;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(length = 50)
	private String userName;
    //    private String password;
    //private String transactionPassword;
	@Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    @Column(length = 15 ,unique = true, nullable = false)
    private String mobileNumber;
    
    @Index(name = "idx_member_id")
    @Column(length = 15 , name = "member_id")
    private String memberId;
  
    @Column(length = 50,unique = true, nullable = false)
    private String email;
    private String address;
    private String profileImageUrl;
    private boolean isActive;
    private String referralId;
    private String androidFCMToken;
    private String iOSFCMToken;
    private String reactFCMToken;
    @Column(length = 50)
    private LocalDate dateOfJoin;
    // New fields for latitude and longitude
    private Double latitude;
    private Double longitude;
}
