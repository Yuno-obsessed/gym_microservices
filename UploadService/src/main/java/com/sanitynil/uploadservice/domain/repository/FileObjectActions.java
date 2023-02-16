package com.sanitynil.uploadservice.domain.repository;

import com.sanitynil.uploadservice.domain.entity.BucketNames;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Repository
public interface FileObjectActions {
    void uploadObject(String file, BucketNames bucketName)throws IOException,
            NoSuchAlgorithmException,
            InvalidKeyException;
    void removeObject(String file, BucketNames bucketName)throws IOException,
    NoSuchAlgorithmException,
    InvalidKeyException;

}
