package com.sanitynil.uploadservice.service;

import com.sanitynil.uploadservice.domain.entity.BucketNames;
import com.sanitynil.uploadservice.domain.repository.FileObjectActions;
import io.minio.MinioClient;
import io.minio.RemoveObjectArgs;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
public class FileObjectActionsService implements FileObjectActions {

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
            InvalidKeyException {
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
        System.out.println("File " + file + " was removed successfully");
    }
}
