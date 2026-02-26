package com.example.demo.upload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public interface UploadService {
    List<String> upload(List<MultipartFile> file);
}
