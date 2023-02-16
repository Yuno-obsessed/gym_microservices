package com.sanitynil.uploadservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum BucketNames {
    BUCKET_USERS("users"),
    BUCKET_QR_CODES("qr.codes");
    private String value;
}
