package com.sanitynil.uploadservice.infra.storage;

import com.sanitynil.uploadservice.domain.entity.BucketNames;
import io.minio.MinioClient;
import io.minio.RemoveObjectArgs;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
@AllArgsConstructor
public class Minio {

    private final MinioClient minioClient;

    public void uploadObject(String file, BucketNames bucketName) throws IOException,
            NoSuchAlgorithmException,
            InvalidKeyException {
        try {
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(bucketName.getValue())
                            .object(file)
                            .filename(file)
                            .build()
            );
        } catch (MinioException e){
            e.printStackTrace();
        }
        System.out.println("File " + file + " was uploaded successfully");
    }

    public void removeObject(String file, BucketNames bucketName) throws IOException,
            NoSuchAlgorithmException,
            InvalidKeyException{
        try{
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                            .bucket(bucketName.getValue())
                            .object(file)
                            .build()
            );
        } catch (MinioException e){
           e.printStackTrace();
        }
        System.out.println("File " + file + " was remover successfully");
    }
}
