package com.bookstore.sharedBook.file.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    void save(List<MultipartFile> multipartFile, String shelfId, String userId);
    List<String> getFileIdsByShelfId(String shelfId);
}
