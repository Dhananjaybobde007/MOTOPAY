package com.logical.tronixpayadmin.model.response;


import com.logical.tronixpayadmin.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

	
	boolean result ; 
	String message;
	Category category;
}
