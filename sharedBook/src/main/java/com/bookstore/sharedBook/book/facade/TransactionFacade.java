package com.bookstore.sharedBook.book.facade;

import com.bookstore.sharedBook.book.dto.request.RequestTransactionDto;
import com.bookstore.sharedBook.book.dto.request.RespondTransactionDto;

public interface TransactionFacade {
    void requestTransaction(String accessToken, RequestTransactionDto requestTransactionDto);
    void acceptTransaction(String accessToken, RespondTransactionDto respondTransactionDto);
}
