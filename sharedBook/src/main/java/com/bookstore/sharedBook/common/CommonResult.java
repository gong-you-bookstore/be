package com.bookstore.sharedBook.common;

import lombok.Data;

@Data
public class CommonResult {
    private boolean success;
    private int code;
    private String msg;

}
