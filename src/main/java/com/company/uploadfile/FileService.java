package com.company.uploadfile;

import com.company.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    private final String uploadDir = "./src/main/resources/templates/uploadFile";

    public void uploadFile(MultipartFile file) {

        try {
            Path path = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}