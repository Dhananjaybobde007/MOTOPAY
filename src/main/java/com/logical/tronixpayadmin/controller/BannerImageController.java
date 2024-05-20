package com.logical.tronixpayadmin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.logical.tronixpayadmin.entity.BannerImage;


@RequestMapping("/admin/banners")
public interface BannerImageController {
	
    @PostMapping("/add")
    public ResponseEntity<?> addBannerImage(@RequestParam(value = "imageUrl", required = true) MultipartFile imageUrl,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "redirectUrl", required = false) String redirectUrl
			);
 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBannerImageById(@PathVariable("id") Long id);

    
    @GetMapping("/getList")
    public ResponseEntity<?> getBannerImageList();
}
