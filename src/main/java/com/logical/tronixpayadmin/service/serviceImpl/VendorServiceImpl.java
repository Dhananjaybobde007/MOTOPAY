package com.logical.tronixpayadmin.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.logical.tronixpayadmin.entity.Vendor;
import com.logical.tronixpayadmin.model.response.GenericResponse;
import com.logical.tronixpayadmin.model.response.MessageResponse;
import com.logical.tronixpayadmin.model.wrapper.VendorWrapper;
import com.logical.tronixpayadmin.repository.VendorRepository;
import com.logical.tronixpayadmin.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	VendorRepository vendorRepository;
	@Override
	public ResponseEntity<?> getVendorsList() {
	     
		List<Vendor> vendors = vendorRepository.findAll();
		  List<VendorWrapper> vendorWrappers = vendors.stream()
	                .map(VendorWrapper::new)
	                .collect(Collectors.toList());
		 return new ResponseEntity<>(new GenericResponse(true , "vendors list get Successfully" ,vendorWrappers ) , HttpStatus.OK);
		
	}
	@Override
	public ResponseEntity<?> getVendorById(Long vendorId) {
		
		boolean isVendorExist = vendorRepository.existsById(vendorId);
		
		if(isVendorExist) {
			Vendor vendor = vendorRepository.findById(vendorId).get();
			VendorWrapper vendorWrapper = new VendorWrapper(vendor);
			 return new ResponseEntity<>(new GenericResponse(true , "vendor details get Successfully",vendorWrapper ) , HttpStatus.OK);
				
		}
else {
	 return new ResponseEntity<>(new MessageResponse(false , "vendor deos not exist  with this vendor id"  ) ,  HttpStatus.NOT_FOUND);
		
		}
			
	}

}
