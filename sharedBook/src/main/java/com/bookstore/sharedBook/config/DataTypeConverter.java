package com.bookstore.sharedBook.config;

import javax.xml.bind.DatatypeConverter;

public class DataTypeConverter {
    public static byte[] hexStringToByteArray(String s) {
        return DatatypeConverter.parseHexBinary(s);
    }
}
