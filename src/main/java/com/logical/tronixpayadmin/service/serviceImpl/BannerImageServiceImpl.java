package com.logical.tronixpayadmin.service.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.logical.tronixpayadmin.entity.BannerImage;
import com.logical.tronixpayadmin.model.response.GenericListResponse;
import com.logical.tronixpayadmin.model.response.GenericResponse;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.repository.BannerImageRepository;
import com.logical.tronixpayadmin.service.BannerImageService;
import com.logical.tronixpayadmin.service.StorageService;

@Service
public class BannerImageServiceImpl implements BannerImageService {

	@Autowired
	BannerImageRepository bannerImageRepository;
	
	@Value("${project.image}")
	String path;
	@Value("${project.videos}")
	String videoPath;
	
	@Autowired
	StorageService fileService;
	
	@Override
	public ResponseEntity<?> addBannerImage(MultipartFile imageUrl, String title, String redirectUrl) {
		
		BannerImage bannerImage = new BannerImage();
		String originalFilename = imageUrl.getOriginalFilename();
		
		String url ="";
		if (originalFilename != null) {
		    if (originalFilename.toLowerCase().endsWith(".mp4") || originalFilename.toLowerCase().endsWith(".avi")) {
		        // It's a video
		    	 url = fileService.uploadFile(videoPath, imageUrl);
		    } else if (originalFilename.toLowerCase().endsWith(".jpg") || originalFilename.toLowerCase().endsWith(".png")) {
		        // It's an image
		    	 url= fileService.uploadFile(path, imageUrl);
		    } else {
		    	return new ResponseEntity<>(new MessageResponse(false , "invalid file format" ) , HttpStatus.BAD_REQUEST);
				  
		    }
		}
	        String[] parts = url.split("/");
	        String filename = parts[parts.length - 1];
	        bannerImage.setImageUrl(filename);
	        bannerImage.setRedirectUrl(redirectUrl);
	        bannerImage.setTitle(title);
	        System.out.println("image name="+ bannerImage.getImageUrl());
	        
		BannerImage saveBannerImage = bannerImageRepository.save(bannerImage);
		
		return new ResponseEntity<>(new GenericResponse<BannerImage>(true, "banner added Successfully", saveBannerImage), HttpStatus.OK);
	
	}

	@Override
	public ResponseEntity<?> deleteBannerImageById(Long id) {
		boolean isBannerImageExist = bannerImageRepository.existsById(id);
		if(isBannerImageExist) {
			BannerImage bannerImage =  bannerImageRepository.findById(id).get();
			String bannerImageUrl = bannerImage.getImageUrl();
					if(!bannerImageUrl.isEmpty()) {
						  if (bannerImageUrl.toLowerCase().endsWith(".mp4") || bannerImageUrl.toLowerCase().endsWith(".avi")) {
						         System.out.println("It's a video");
						         //It's a video
						    	  fileService.deleteVideosFile(bannerImageUrl);
						    } else if (bannerImageUrl.toLowerCase().endsWith(".jpg") || bannerImageUrl.toLowerCase().endsWith(".png")) {
						        System.out.println("It's a image");
						    	// It's an image
						    	fileService.deleteImageFile( bannerImageUrl);				
						    }
						
					}
					bannerImageRepository.deleteById(id);
					return new ResponseEntity<>(new MessageResponse(true , "bannerImage deleted successfully" ) , HttpStatus.OK);
			}
		else {
			return new ResponseEntity<>(new MessageResponse(false , "bannerImageId doesn't exist" ) , HttpStatus.NOT_FOUND);
			
		}
			}
	
	@Override
	public ResponseEntity<?> getBannerImageList() {
		
		List<BannerImage> bannerImageList = bannerImageRepository.findAll();
		
		return new ResponseEntity<>(new GenericListResponse (true, "get banner images successfully" ,bannerImageList), HttpStatus.OK);

	}


}
