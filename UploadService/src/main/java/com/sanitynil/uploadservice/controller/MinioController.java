package com.sanitynil.uploadservice.controller;

import com.sanitynil.uploadservice.domain.entity.BucketNames;
import com.sanitynil.uploadservice.domain.entity.FileObject;
import com.sanitynil.uploadservice.service.FileObjectActionsService;
import com.sanitynil.uploadservice.service.FileObjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = "/api/v1/upload-service")
public class MinioController {

    private static final Logger logger = LoggerFactory.getLogger(MinioController.class);

    @Autowired
    private FileObjectActionsService fileObjectActionsService;

    @Autowired
    private FileObjectService fileObjectService;

    @PostMapping(value = "/upload/{entity}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> uploadFile(
           @RequestParam("file") MultipartFile multipartFile,
//           @RequestParam("body") String jsonBody,
           @PathVariable("entity") String bucketName){
        BucketNames bucket;
        try {
                bucket = BucketNames.valueOf(bucketName);
            } catch (IllegalArgumentException e) {
            logger.error("Wrong bucketName referenced in the request.\n" + e.getMessage());
                return ResponseEntity.status(401).body("Malformed request");
            }

        try {
            fileObjectActionsService.uploadObject(multipartFile.getOriginalFilename(), bucket);
        } catch (Exception e){
            logger.error("Error uploading object to minio.\n" + e.getMessage());
            return ResponseEntity.status(401).body("Malformed request");
        }
       fileObjectService.save(new FileObject(multipartFile.getOriginalFilename(), bucket.getValue()));

       return ResponseEntity.status(200).body("Success");
    }

   @PostMapping(value = "/upload/{entity}",
           consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<String> deleteFile(
           @RequestParam("file") MultipartFile multipartFile,
           @PathVariable("entity") String bucketName){
        BucketNames bucket;
        try {
            bucket = BucketNames.valueOf(bucketName);
        } catch (IllegalArgumentException e){
            logger.error("Wrong bucketName referenced in the request.\n" + e.getMessage());
            return ResponseEntity.status(401).body("Malformed request");
        }

        try{
            fileObjectActionsService.removeObject(multipartFile.getOriginalFilename(),bucket);
        } catch (Exception e){
            logger.error("Error removing object from minio.\n" + e.getMessage());
            return ResponseEntity.status(401) .body("Malformed request");
        }
        fileObjectService.deleteFileObject(new FileObject(multipartFile.getOriginalFilename(), bucket.getValue()));

        return ResponseEntity.status(200).body("Success");
   }

}
