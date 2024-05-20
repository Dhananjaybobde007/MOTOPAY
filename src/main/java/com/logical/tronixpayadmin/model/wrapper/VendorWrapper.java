package com.logical.tronixpayadmin.model.wrapper;
import com.logical.tronixpayadmin.entity.Vendor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorWrapper {

    private Long vendorId;
    private String vendorGenId;
    private String referralId;
    private String memberId; // User memberId only
    private String dateOfBirth;
    private String name;
    private String adharNumber;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    private String email;
    private String mobileNumber;
    private String memberImageUrl;
    private Long categoryId; // Changed to categoryId only
    private String businessName;
    private String businessAddress;
    private String businessMobile;
    private String businessEmail;
    private String businessDescription;
    private String businessLocation;
    private String dateOfJoin;
    private Double latitude;
    private Double longitude;

    public VendorWrapper(Vendor vendor) {
        this.vendorId = vendor.getVendorId();
        this.vendorGenId = vendor.getVendorGenId();
        this.referralId = vendor.getReferralId();
        if (vendor.getUser() != null) {
            this.memberId = vendor.getUser().getMemberId();
        }
        this.dateOfBirth = vendor.getDateOfBirth().toString(); // Convert to String
        this.name = vendor.getName();
        this.adharNumber = vendor.getAdharNumber();
        this.address = vendor.getAddress();
        this.city = vendor.getCity();
        this.state = vendor.getState();
        this.country = vendor.getCountry();
        this.pinCode = vendor.getPinCode();
        this.email = vendor.getEmail();
        this.mobileNumber = vendor.getMobileNumber();
        this.memberImageUrl = vendor.getMemberImageUrl();
        if (vendor.getCategory() != null) {
            this.categoryId = vendor.getCategory().getCategoryId();
        }
        this.businessName = vendor.getBusinessName();
        this.businessAddress = vendor.getBusinessAddress();
        this.businessMobile = vendor.getBusinessMobile();
        this.businessEmail = vendor.getBusinessEmail();
        this.businessDescription = vendor.getBusinessDescription();
        this.businessLocation = vendor.getBusinessLocation();
        this.dateOfJoin = vendor.getDateOfJoin().toString(); // Convert to String
        this.latitude = vendor.getLatitude();
        this.longitude = vendor.getLongitude();
    }
}
