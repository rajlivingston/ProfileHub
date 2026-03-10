package com.livingston.ProfileHub.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FileUploadConfig {

    private final String uploadDir = "uploads/";

    public String getUploadDir() {
        return uploadDir;
    }
}