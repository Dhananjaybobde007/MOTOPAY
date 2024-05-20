package com.logical.tronixpayadmin.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface CategoryService {

		public ResponseEntity<?> addCategory(MultipartFile multipartFile, String categoryName) throws IOException;

		public ResponseEntity<?> getCategoryById(Long categoryId);

		public ResponseEntity<?> getCategoryList();

		public ResponseEntity<?> updateCategory(Long categoryId, String categoryName, MultipartFile multipartFile);

		public ResponseEntity<?> deleteCategory(Long categoryId);

		
}
