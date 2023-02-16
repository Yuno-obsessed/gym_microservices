package com.sanitynil.uploadservice.infra.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.MinioProperties;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(ConfigProperties.class);
    private String accessKey;
    private String secretKey;
    private List<String> buckets;

    @Bean
    public MinioClient minioClient() throws Exception {
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("http:localhost/", 9000, false)
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
                    logger.info("Bucket " + bucket + " already exists");
                }
            }
      return minioClient;
    }

}
