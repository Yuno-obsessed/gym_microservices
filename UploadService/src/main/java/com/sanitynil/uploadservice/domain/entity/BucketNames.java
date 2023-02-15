package com.sanitynil.uploadservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
public enum BucketNames {
    BUCKET_USERS("users"),
    BUCKET_PRODUCTS("products");
    private final String value;
}
