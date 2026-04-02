package com.ai.service.impl;

import com.ai.model.ApiResponse;
import com.ai.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public ApiResponse processFile(MultipartFile file) {
        String fileType=file.getContentType();
        String fileName=file.getOriginalFilename();
        if(fileType==null || fileName==null
            || (!fileType.equals("application/pdf")
                &&!fileType.equals("text/plain"))
            || (!fileName.endsWith(".pdf")&& !fileName.endsWith(".txt"))){

            return new ApiResponse(
                    "Only PDF and TXT files are allowed",
                    "error",
                    400
            );
        }

        return new ApiResponse(
                "File Received: "+fileName,
                "success",
                200
        );
    }
}
