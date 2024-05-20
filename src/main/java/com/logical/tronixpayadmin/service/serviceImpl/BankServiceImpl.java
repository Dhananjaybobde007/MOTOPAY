package com.logical.tronixpayadmin.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.logical.tronixpayadmin.entity.Bank;
import com.logical.tronixpayadmin.entity.Category;
import com.logical.tronixpayadmin.model.response.CategoryResponse;
import com.logical.tronixpayadmin.model.response.GenericResponse;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.repository.BankRepository;
import com.logical.tronixpayadmin.service.BankService;
import com.logical.tronixpayadmin.service.StorageService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	StorageService fileService;
	@Value("${project.image}")
	String path;
	@Autowired
	BankRepository bankRepository;
	
	@Override
	public ResponseEntity<?> createBank(String bankName, MultipartFile imageUrl) {
	    Bank bank = new Bank();
	    bank.setBankName(bankName);

	    boolean isBankExist = bankRepository.existsByBankNameIgnoreCase(bankName);
	    if (!isBankExist) {
	        if (imageUrl != null && !imageUrl.isEmpty()) {
	            try {
	            	 String url = fileService.uploadFile(path, imageUrl);
	 		        String[] parts = url.split("/");
	 		        String filename = parts[parts.length - 1];
	 		        bank.setImageUrl(filename);
	            } catch (Exception e) {
	                e.printStackTrace();
	                return new ResponseEntity<>("Failed to upload image", HttpStatus.INTERNAL_SERVER_ERROR);
	            }
	        }
	        bankRepository.save(bank);
	        return new ResponseEntity<>("Bank created successfully", HttpStatus.CREATED);
	    } else {
	        return new ResponseEntity<>("Bank already exists", HttpStatus.BAD_REQUEST);
	    }
	}
	
	public ResponseEntity<?> getBanksList() {
		List<Bank> banks = bankRepository.findAll();
			return new ResponseEntity<>(new GenericResponse(true , "banks  get successfully" , banks ), HttpStatus.OK);
		}

	@Override
	public ResponseEntity<?> updateBank(Long bankId, String bankName, MultipartFile imageUrl) {
		boolean isBankExist = bankRepository.existsById(bankId);
		if(isBankExist) {
			Bank bank =  bankRepository.findById(bankId).get();
			bank.setBankName(bankName);
				if (imageUrl != null && !imageUrl.isEmpty()) { 
				
				String bankImg = bank.getImageUrl();
				if (bankImg != null || !bankImg.isEmpty()) {
					fileService.deleteImageFile(bankImg);
				}
				//upload update image
				String url = fileService.uploadFile(path, imageUrl);
			    String[] parts = url.split("/");
			    String filename = parts[parts.length - 1];
			    bank.setImageUrl(filename);
			    System.out.println("new image name="+   bank.getImageUrl());	
				
			}
				bankRepository.save(bank);
			 return new ResponseEntity<>(new GenericResponse(true , "Bank updated Successfully" , bank) , HttpStatus.OK);
		
			
		}
		else {
			return new ResponseEntity<>(new MessageResponse(false , "bank not exist with given bankId" ) , HttpStatus.NOT_FOUND);	
		}
		
	}

	@Override
	public ResponseEntity<?> getBankById(Long bankId) {
		boolean isCategoryExist = bankRepository.existsById(bankId);
		if(isCategoryExist) {
			Bank bankData =  bankRepository.findById(bankId).get();
			 return new ResponseEntity<>(new GenericResponse(true , "Bank details get Successfully" , bankData) , HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(new MessageResponse(false , "Bank not exist with given BankId" ) , HttpStatus.NOT_FOUND);
		}
	}
	
		
		
		
		
		
		
		


}
