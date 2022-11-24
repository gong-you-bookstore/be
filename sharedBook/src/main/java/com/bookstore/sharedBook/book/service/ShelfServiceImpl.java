package com.bookstore.sharedBook.book.service;

import com.bookstore.sharedBook.book.dto.request.PatchShelfStatusRequestDto;
import com.bookstore.sharedBook.book.dto.request.SaveBookRequestDto;
import com.bookstore.sharedBook.book.dto.request.ShelfDetailRequestDto;
import com.bookstore.sharedBook.book.dto.response.ShelfDetailResponseDto;
import com.bookstore.sharedBook.book.entity.Shelf;
import com.bookstore.sharedBook.book.repository.ShelfRepositoryImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ShelfServiceImpl implements ShelfService{
    private final ShelfRepositoryImpl shelfRepository;

    public Shelf save(String userId, SaveBookRequestDto saveBookRequestDto){
        Shelf shelf = Shelf.builder()
                .isbn(saveBookRequestDto.getIsbn())
                .userId(UUID.fromString(userId))
                .status(saveBookRequestDto.getStatus().toUpperCase())
                .token(saveBookRequestDto.getToken())
                .latitude(saveBookRequestDto.getLatitude())
                .longitude(saveBookRequestDto.getLongitude())
                .build();
        return shelfRepository.save(shelf);
    }

    @Override
    public List<String> getUserEmailsByIsbn(Long isbn) {
        List<String> res = new ArrayList<>();
        for(String email : shelfRepository.getUserEmailsByIsbn(isbn)){
            res.add(email);
        }
        return res;
    }

    @Override
    public Shelf getShelf(ShelfDetailRequestDto shelfDetailRequestDto) {
        return shelfRepository.getShelf(shelfDetailRequestDto.getIsbn(), UUID.fromString(shelfDetailRequestDto.getUserId()));

    }

    @Override
    public void patchShelfStatus(String shelfId, String status) {
        shelfRepository.patchShelfStatus(UUID.fromString(shelfId), status);
    }
}
