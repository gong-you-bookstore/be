package com.bookstore.sharedBook.file.repository;

import com.bookstore.sharedBook.file.entity.File;

import java.util.List;
import java.util.UUID;

public interface FileRepository {
    File save(File file);
    List<UUID> findFileIdsByShelfId(UUID shelfId);
    List<String> findFileNamesByShelfId(UUID shelfId);
    //List<File> findAllFiles(String bookId);
    //void delete(UUID fileId);
}
