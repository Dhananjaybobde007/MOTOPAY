package com.logical.tronixpayadmin.entity;


import com.logical.tronixpayadmin.enums.CategoryType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="category")
public class Category {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "category_id") 
		public Long categoryId;
        
        @Column(length = 50)
	    public String categoryName;
	    public String categoryImageUrl;
//	    @Enumerated(EnumType.STRING)
//	    private CategoryType categoryType;
}
