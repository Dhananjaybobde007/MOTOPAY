package com.logical.tronixpayadmin.businessServices;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DateUtilsService {
	 public LocalDate getLocalDate() {
		  ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		   return LocalDate.now(zoneId);
		   
	  };
	  
	  public LocalDateTime getLocalDateTime() {
		  ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		   return LocalDateTime.now(zoneId);
		   
	  }
	  
	  public static String getCurrentDateTime() {
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a");
	        return now.format(formatter);
	    }
	  
	  public  String getLocalDateTimeToString(  LocalDateTime localDateTime ) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a");
	        return localDateTime.format(formatter);
	    }
}
