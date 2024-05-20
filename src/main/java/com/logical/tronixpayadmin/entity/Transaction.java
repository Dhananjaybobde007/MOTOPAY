package com.logical.tronixpayadmin.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.logical.tronixpayadmin.enums.PaymentMode;
import com.logical.tronixpayadmin.enums.TransactionStatus;

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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(length = 50 ,unique = false, nullable = false)
	    private String transactionId;
	    
	    private double amount;
	    
	    @Enumerated(EnumType.STRING) // Specify EnumType.STRING to store enum values as strings
	    private PaymentMode paymentMode; 
	   
	    @Enumerated(EnumType.STRING) // Specify EnumType.STRING to store enum values as strings
	    private TransactionStatus transactionStatus;
	    
	    @ManyToOne(fetch = FetchType.LAZY )
	    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private User user;
	   
	    @ManyToOne(fetch = FetchType.LAZY )
	    @JoinColumn(name = "vendor_gen_id", referencedColumnName = "vendor_gen_id")
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private Vendor vendor;
	    
	    @Column(nullable = false)
	    private LocalDateTime transactionDateTime;
	    	
}
