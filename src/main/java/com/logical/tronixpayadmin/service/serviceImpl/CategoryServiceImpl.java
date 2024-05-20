package com.logical.tronixpayadmin.service.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.logical.tronixpayadmin.entity.Category;
import com.logical.tronixpayadmin.model.response.CategoryResponse;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.repository.CategoryRepository;
import com.logical.tronixpayadmin.service.CategoryService;
import com.logical.tronixpayadmin.service.StorageService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	 @Autowired
	    StorageService fileService;
	   @Value("${project.image}")
	    String path;
	   
	   
	@Override
	public ResponseEntity<?> addCategory(MultipartFile multipartFile, String categoryName)  throws IOException{
		
		boolean isCategoryExist = categoryRepository.existsByCategoryNameIgnoreCase(categoryName);
		if (!isCategoryExist) {
			 Category categoryData = new Category();
			    categoryData.setCategoryName(categoryName);
			  
			    //aws file upload
			    if (multipartFile != null && !multipartFile.isEmpty()) {
			    
			    String url = fileService.uploadFile(path, multipartFile);
		        String[] parts = url.split("/");
		        String filename = parts[parts.length - 1];
		        categoryData.setCategoryImageUrl(filename);
		        System.out.println("image name="+ categoryData.getCategoryImageUrl());
		        }
			    categoryData = categoryRepository.save(categoryData);
			 return new ResponseEntity<>(new CategoryResponse(true , "Category added successfully" , categoryData) , HttpStatus.OK);
			  
	    }
		else {
			return new ResponseEntity<>(new MessageResponse(false , "Category already exist" ) , HttpStatus.BAD_REQUEST);
		}

	}


	@Override
	public ResponseEntity<?> getCategoryById(Long categoryId) {
		boolean isCategoryExist = categoryRepository.existsById(categoryId);
		if(isCategoryExist) {
			Category categoryData =  categoryRepository.findById(categoryId).get();
			 return new ResponseEntity<>(new CategoryResponse(true , "Category details get Successfully" , categoryData) , HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(new MessageResponse(false , "Category not exist with given categoryId" ) , HttpStatus.NOT_FOUND);
		}
	}


	@Override
	public ResponseEntity<?> getCategoryList() {
		
		List<Category> categoryList = categoryRepository.findAll();
		
		return ResponseEntity.ok(categoryList);
		
	}


	@Override
	public ResponseEntity<?> updateCategory(Long categoryId, String categoryName, MultipartFile multipartFile) {
		boolean isCategoryExist = categoryRepository.existsById(categoryId);
		if(isCategoryExist) {
			Category categoryData =  categoryRepository.findById(categoryId).get();
			categoryData.setCategoryName(categoryName);
			
			if (multipartFile != null && !multipartFile.isEmpty()) { 
				
				String categoryImg = categoryData.getCategoryImageUrl();
				if (categoryImg != null || !categoryImg.isEmpty()) {
					fileService.deleteImageFile(categoryImg);
				}
				//upload update image
				String url = fileService.uploadFile(path, multipartFile);
			    String[] parts = url.split("/");
			    String filename = parts[parts.length - 1];
			    categoryData.setCategoryImageUrl(filename);
			    System.out.println("new image name="+ categoryData.getCategoryImageUrl());	
				
			}
			categoryRepository.save(categoryData);
			 return new ResponseEntity<>(new CategoryResponse(true , "Category updated Successfully" , categoryData) , HttpStatus.OK);
			}
		else {
			return new ResponseEntity<>(new MessageResponse(false , "CategoryId not exist with given categoryId" ) , HttpStatus.NOT_FOUND);	
		}
	
	}


	@Override
	public ResponseEntity<?> deleteCategory(Long categoryId) {
//	boolean isCategoryExist = categoryRepository.existsById(categoryId);
//		
//		if(isCategoryExist) {
//			categoryRepository
//		}
//		else {
//			return new ResponseEntity<>(new MessageResponse(false , "CategoryId not exist with given categoryId" ) , HttpStatus.NOT_FOUND);	
//		
//		}
		return null;
		
	}
	
}

