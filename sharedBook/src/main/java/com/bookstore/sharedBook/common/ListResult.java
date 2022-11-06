package com.bookstore.sharedBook.common;

import lombok.Data;

import java.util.List;

@Data
public class ListResult<T> extends CommonResult{
    private List<T> data;
}
