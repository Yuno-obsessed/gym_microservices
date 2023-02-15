package com.sanitynil.uploadservice.infra.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.MinioProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "minio")
@ConfigurationPropertiesScan
public class ConfigProperties {
    private String accessKey;
    private String secretKey;
    private List<String> buckets;

    @Bean
    public MinioClient minioClient() throws Exception {
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("minio", 9000, false)
                        .credentials(accessKey, secretKey)
                        .region("eu-east-1")
                        .build();
        for(String bucket : buckets){
                if (!minioClient.bucketExists(
                        BucketExistsArgs.builder()
                        .bucket(bucket)
                        .build())) {

                    minioClient.makeBucket(
                            MakeBucketArgs.builder()
                            .bucket(bucket)
                            .build());
                } else{
                    System.out.println("Bucket " + bucket + " already exists");
                }
            }
      return minioClient;
    }

}
