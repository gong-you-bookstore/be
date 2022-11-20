package com.bookstore.sharedBook.file.repository;

import com.bookstore.sharedBook.file.entity.File;
import com.bookstore.sharedBook.file.entity.QFile;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class FileRepositoryImpl implements FileRepository{
    private final FileJpaRepository fileJpaRepository;
    private final JPAQueryFactory jpaQueryFactory;
    private final QFile file = QFile.file;

    @Override
    public File save(File file) {
        return fileJpaRepository.save(file);
    }

    @Override
    public List<UUID> findFileIdsByShelfId(UUID shelfId) {
        return jpaQueryFactory
                .select(file.id)
                .from(file)
                .where(file.shelfId.eq(shelfId))
                .fetch();
    }

//    @Override
//    public List<File> findAllFiles(String bookId) {
//        return jpaQueryFactory
//                .selectFrom(file)
//                .where(file.bookId.eq(UUID.fromString(bookId)))
//                .fetch();
//    }
//
//    @Override
//    public void delete(UUID fileId) {
//        fileJpaRepository.deleteById(fileId);
//    }
}
