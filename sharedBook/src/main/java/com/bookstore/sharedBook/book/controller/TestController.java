package com.bookstore.sharedBook.book.controller;

import com.bookstore.sharedBook.file.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/test")
public class TestController {
    private final StorageService storageService;

    @PostMapping("/storage")
    public List<String> uploadFile(@RequestPart List<MultipartFile> multipartFile) {
        return storageService.uploadFile(multipartFile);
    }
}
