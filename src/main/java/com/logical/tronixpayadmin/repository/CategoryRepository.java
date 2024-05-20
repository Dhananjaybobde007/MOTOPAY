package com.logical.tronixpayadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logical.tronixpayadmin.entity.Category;

public interface CategoryRepository extends JpaRepository<Category , Long> {

	
	boolean existsByCategoryNameIgnoreCase(String categoryName);

}
