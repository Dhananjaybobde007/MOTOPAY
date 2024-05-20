
package com.logical.tronixpayadmin.entity;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "vendor")
public class Vendor {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_id")
	private Long vendorId;
	
	@Column(name = 	"vendor_gen_id" ,length = 15 ,unique = true, nullable = false)
	private String vendorGenId;
    private String referralId;

//    @Enumerated(EnumType.STRING)
//    private MemberType memberType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private User user;

    
    private Date dateOfBirth;
    private String name;

    @Pattern(regexp="[0-9]{12}", message="Aadhaar number must be exactly 12 digits long and contain only numeric characters.")
    @Column(length = 15, nullable = true) // Consider if Aadhaar number is optional
    private String adharNumber;

    private String address;
    private String city;
    private String state;
    private String country;

    @Pattern(regexp="[0-9]{6}", message="PIN code must be exactly 6 digits long and contain only numeric characters.")
    @Column(nullable = true) // Consider if PIN code is optional
    private String pinCode;

    @Column(length = 50, unique = true, nullable = true) // Consider if email is optional
    private String email;

    @Column(length = 15, unique = true, nullable = false)
    private String mobileNumber;

    private String memberImageUrl;

    // Many-to-One relationship with Category
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;

    @Column(length = 100, nullable = true) 
    private String businessName;

    private String businessAddress; 

    @Column(length = 15, unique = true, nullable = false)
    private String businessMobile;

    @Column(length = 50, unique = true, nullable = true) 
    private String businessEmail;

    private String businessDescription;
    private String businessLocation;
    
    @Column(length = 50)
    private LocalDate  dateOfJoin;
    
    private Double latitude;
    private Double longitude;
    

}

