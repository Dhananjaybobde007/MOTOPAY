package com.logical.tronixpayadmin.model.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.logical.tronixpayadmin.entity.QRCodeDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QRCodeCashbackRequestWrapper {

    @JsonProperty("qrCodeDetailsId")
    private Long qrCodeDetailsId;

    @JsonProperty("approveStatus")
    private boolean approveStatus;

    @JsonProperty("cashbackPercent")
    private double cashbackPercent;

    @JsonProperty("vendorId")
    private Long vendorId;

    @JsonProperty("vendorGenId")
    private String vendorGenId;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("memberId")
    private String memberId;
    
    @JsonProperty("userName")
    private String userName;

    @JsonProperty("profileImageUrl")
    private String profileImageUrl;

    @JsonProperty("adharNumber")
    private String adharNumber;

    @JsonProperty("mobileNumber")
    private String mobileNumber;

    @JsonProperty("businessEmail")
    private String businessEmail;
    
    public QRCodeCashbackRequestWrapper(QRCodeDetails qrCodeDetails) {
    	  this.qrCodeDetailsId = qrCodeDetails.getQrCodeDetailsId();
          this.approveStatus = qrCodeDetails.isApproveStatus();
          this.cashbackPercent = qrCodeDetails.getCashbackPercent();
          this.vendorId = qrCodeDetails.getVendor().getVendorId();
          this.vendorGenId = qrCodeDetails.getVendor().getVendorGenId();
          this.userId = qrCodeDetails.getVendor().getUser().getUserId();
          this.memberId = qrCodeDetails.getVendor().getUser().getMemberId();
          this.userName = qrCodeDetails.getVendor().getUser().getUserName();
          this.profileImageUrl = qrCodeDetails.getVendor().getUser().getProfileImageUrl();
          this.adharNumber = qrCodeDetails.getVendor().getAdharNumber();
          this.mobileNumber = qrCodeDetails.getVendor().getUser().getMobileNumber();
          this.businessEmail = qrCodeDetails.getVendor().getBusinessEmail();
    }
    
}
