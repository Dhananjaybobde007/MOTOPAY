package com.logical.tronixpayadmin.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	public String uploadFile(String path,MultipartFile file);
	
    public byte[] downloadFile(String fileName);
	 
    public String deleteImageFile(String fileUrl);
    
    public String deleteVideosFile(String fileUrl);
    
}
