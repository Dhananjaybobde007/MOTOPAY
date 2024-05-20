package com.logical.tronixpayadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/admin/category")
public interface CategoryController {

	
	 @PostMapping("/addCategory")
		public ResponseEntity<?> addCategory(@RequestParam("categoryName") String  categoryName, @RequestParam("categoryImage") MultipartFile multipartFile) ;
	
	 @DeleteMapping("/deleteCategory/{categoryId}")
	    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId);
	 
	 @GetMapping("/getCategoryById/{categoryId}")
	    public ResponseEntity<?> getCategoryById(@PathVariable Long categoryId);
	 
	 @GetMapping("/getCategoryList")
	    public ResponseEntity<?> getCategoryList();
	 
	 @PostMapping("/updateCategory")
	    public ResponseEntity<?>  updateCategory(@RequestParam("categoryId") Long categoryId , @RequestParam("categoryName") String categoryName ,  @RequestParam(value ="categoryImage" , required = false) MultipartFile multipartFile);
}
