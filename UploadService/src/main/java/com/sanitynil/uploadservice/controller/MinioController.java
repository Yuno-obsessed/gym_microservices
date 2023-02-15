package com.sanitynil.uploadservice.controller;

import com.sanitynil.uploadservice.domain.entity.BucketNames;
import com.sanitynil.uploadservice.domain.entity.FileObject;
import com.sanitynil.uploadservice.infra.storage.Minio;
import com.sanitynil.uploadservice.service.FileObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/v1/upload-service")
public class MinioController {

    @Autowired
    private Minio minio;

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
                return ResponseEntity.status(401).body("Malformed request");
            }
        try {
            minio.uploadObject(multipartFile.getOriginalFilename(), bucket);
        } catch (Exception e){
            return ResponseEntity.status(401).body("Malformed request");
        }
       fileObjectService.save(new FileObject(multipartFile.getOriginalFilename(), bucket.getValue()));

       return ResponseEntity.status(200).body("Success");
   }
}
