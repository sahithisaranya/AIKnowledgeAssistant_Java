package com.ai.controller;

import com.ai.model.ApiResponse;
import com.ai.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/assistant")
public class UploadController {

    private final FileService fileService;
    public UploadController(FileService fileService){
        this.fileService=fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse> uploadFile(@RequestParam("file")MultipartFile multipartFile){
        ApiResponse apiResponse=fileService.processFile(multipartFile);
        return ResponseEntity.status(apiResponse.getStatusCode())
                .body(apiResponse);
    }
}
