package com.logical.tronixpayadmin.controller.controllerImpl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.logical.tronixpayadmin.controller.CategoryController;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.service.CategoryService;

@RestController
public class CategoryControllerImpl implements CategoryController {

	private Logger logger = LoggerFactory.getLogger(CategoryControllerImpl.class);
	
	@Autowired
	CategoryService categoryService;

	public ResponseEntity<?> addCategory(String categoryName, MultipartFile multipartFile) {
	try {
			return categoryService.addCategory(multipartFile, categoryName);
		}  catch (IOException e) {
            
            logger.error("IOException occurred: " + e.getMessage());
            return new ResponseEntity<>(
                    new MessageResponse(false, "An error occurred while processing your request."),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } 
	       catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> deleteCategory(Long categoryId) {
		try {
			return categoryService.deleteCategory(categoryId);
		} 
	       catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> getCategoryById(Long categoryId) {
		try {
			return categoryService.getCategoryById(categoryId);
		} 
	       catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@Override
	public ResponseEntity<?> getCategoryList() {
		try {
			return categoryService.getCategoryList();
		} 
	       catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		
	}

	@Override
	public ResponseEntity<?> updateCategory(Long categoryId, String categoryName, MultipartFile multipartFile) {
		try {
			return categoryService.updateCategory(categoryId , categoryName , multipartFile );
		} 
	       catch (Exception e) {
			logger.info(" " + e);
			return new ResponseEntity<>(
					new MessageResponse(false,
							"Something went wrong...Don't very we are figuring out what went wrong...!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	
	
	
	  

}
