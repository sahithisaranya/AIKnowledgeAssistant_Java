package com.ai.service;

import com.ai.model.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public ApiResponse processFile(MultipartFile file);
}
