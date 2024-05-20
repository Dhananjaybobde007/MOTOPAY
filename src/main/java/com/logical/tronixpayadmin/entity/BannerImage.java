package com.logical.tronixpayadmin.entity;

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
@Table(name="banner_image")
public class BannerImage {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "banner_image_id") 
		public Long id;
	    private String imageUrl; 
	    private String title; 
	    private String redirectUrl; 
	    private boolean isActive;

}
