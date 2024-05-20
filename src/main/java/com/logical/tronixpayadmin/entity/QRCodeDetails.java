package com.logical.tronixpayadmin.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "qr_code_details")
public class QRCodeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qr_code_details_id")
	private Long qrCodeDetailsId;
	
	@Column(name = "approve_status")
	private boolean approveStatus;
	
	@Column(name = "cashback_percent")
    private double cashbackPercent;
	
	@Column(name = "request_status")
	private boolean requestStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_gen_id", referencedColumnName = "vendor_gen_id")
	private Vendor vendor;

	
	
}
