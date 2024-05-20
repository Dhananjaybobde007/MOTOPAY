package com.logical.tronixpayadmin.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "refund_policy")
public class RefundPolicy {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    public int id;

		 @Column(nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
		    public String title;

		    @Column(length = 1000, nullable = false, columnDefinition = "VARCHAR(1000) DEFAULT ''")
		    public String description;
	    
	    private LocalDate dateOfCreation;
}
