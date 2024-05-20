package com.logical.tronixpayadmin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryRequest {
	
	public String categoryName;
	public String categoryImageUrl;
	public String categoryType;

}
