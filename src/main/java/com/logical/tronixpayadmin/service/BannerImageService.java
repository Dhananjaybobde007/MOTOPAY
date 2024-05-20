package com.logical.tronixpayadmin.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.logical.tronixpayadmin.entity.BannerImage;

public interface BannerImageService {

	public ResponseEntity<?> addBannerImage(MultipartFile imageUrl, String title, String redirectUrl);

	public ResponseEntity<?> deleteBannerImageById(Long id);

	public ResponseEntity<?> getBannerImageList();

}
