package com.bookstore.sharedBook.file.repository;

import com.bookstore.sharedBook.file.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FileJpaRepository extends JpaRepository<File, UUID> {
}
