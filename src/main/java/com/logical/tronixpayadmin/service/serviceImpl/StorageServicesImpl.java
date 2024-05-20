package com.logical.tronixpayadmin.service.serviceImpl;
import com.logical.tronixpayadmin.service.StorageService;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class StorageServicesImpl implements StorageService{
    @Value("${application.bucket.name}")
    private String bucketName;
    @Autowired
    private AmazonS3 s3Client;


    public String uploadFile(String path,MultipartFile file) {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName =path+System.currentTimeMillis() + "_" + file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        fileObj.delete();
        return "https://motopaystorages.s3.ap-south-1.amazonaws.com/"+fileName;
    }
    public byte[] downloadFile(String fileName) {
        S3Object s3Object = s3Client.getObject(bucketName, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String deleteImageFile(String url) {
    	String fileUrl = "https://motopaystorages.s3.ap-south-1.amazonaws.com/images/" + url ;
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("com/")+4);
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " removed ...";
    }
    public String deleteVideosFile(String url) {
    	System.out.println("deleteVideosFile"+ url);
    	String fileUrl = "https://motopaystorages.s3.ap-south-1.amazonaws.com/videos/" + url ;
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("com/")+4);
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " removed ...";
    }
    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }
}

