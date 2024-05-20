package com.logical.tronixpayadmin.controller.controllerImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.logical.tronixpayadmin.controller.BannerImageController;
import com.logical.tronixpayadmin.service.BannerImageService;
import com.logical.tronixpayadmin.entity.BannerImage;
import com.logical.tronixpayadmin.model.response.MessageResponse;

@RestController
public class BannerImageControllerImpl implements BannerImageController {
	
	@Autowired
    BannerImageService bannerImageService;
	private Logger logger = LoggerFactory.getLogger(BannerImageControllerImpl.class);
	

	@Override
	public ResponseEntity<?> addBannerImage(MultipartFile imageUrl, String title, String redirectUrl) {
		try {
			
	        return bannerImageService.addBannerImage(imageUrl ,title , redirectUrl );

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
	public ResponseEntity<?> deleteBannerImageById(Long id) {
		try {																													
			return bannerImageService.deleteBannerImageById(id);
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
	public ResponseEntity<?> getBannerImageList() {
		try {
			
	        return bannerImageService.getBannerImageList();

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
