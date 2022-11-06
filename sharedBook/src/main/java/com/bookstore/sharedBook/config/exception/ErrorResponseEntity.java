package com.bookstore.sharedBook.config.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ErrorResponseEntity {
    private Boolean success;
    private Integer code;
    private String msg;

    public static ResponseEntity<ErrorResponseEntity> toResponseEntity(ErrorCode e){
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(ErrorResponseEntity.builder()
                        .success(e.getSuccess())
                        .code(e.getHttpStatus().value())
                        .msg(e.getMessage())
                        .build()
                );
    }
}
