package com.bookstore.sharedBook.file.service;

import com.bookstore.sharedBook.file.entity.File;
import com.bookstore.sharedBook.file.repository.FileRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{
    private final StorageService storageService;
    private final FileRepositoryImpl fileRepository;
    @Value("${bucket.url}")
    private String bucketUrl;
    @Override
    public void save(List<MultipartFile> multipartFile, String shelfId, String userId) {
        List<String> fileNameList = storageService.uploadFile(multipartFile);
        for(String filename : fileNameList){
            File file = File.builder()
                    .name(filename)
                    .shelfId(UUID.fromString(shelfId))
                    .uploaderId(UUID.fromString(userId))
                    .build();
            fileRepository.save(file);
        }

    }

    @Override
    public List<String> getFileIdsByShelfId(String shelfId) {
        List<UUID> rets = fileRepository.findFileIdsByShelfId(UUID.fromString(shelfId));
        List<String> res = new ArrayList<>();
        for(UUID ret : rets){
            res.add(ret.toString());
        }
        return res;
    }

    @Override
    public List<String> getFileNamesByShelfId(String shelfId) {
        return fileRepository.findFileNamesByShelfId(UUID.fromString(shelfId));
    }

    @Override
    public List<String> getFileUrlFromFileNameList(List<String> fileNames) {
        List<String> res = new ArrayList<>();
        for(String file : fileNames){
            String url = bucketUrl+file;
            res.add(url);
        }
        return res;
    }
}
