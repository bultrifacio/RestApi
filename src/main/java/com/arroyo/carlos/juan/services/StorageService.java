package com.arroyo.carlos.juan.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

	public void saveFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("./src/main/resources/files/" + file.getOriginalFilename());
            if(!Files.exists(path)) Files.write(path, bytes);
        }
    }

    public UrlResource loadFile(String fileName) throws MalformedURLException {
        Path file = Paths.get( "./src/main/resources/files/"+fileName);
        UrlResource resource = new UrlResource(file.toUri());
        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new RuntimeException("Image not found");
        }
    }

}
