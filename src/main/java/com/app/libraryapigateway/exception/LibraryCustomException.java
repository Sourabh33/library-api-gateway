package com.app.libraryapigateway.exception;

import org.springframework.http.HttpStatus;

public class LibraryCustomException extends RuntimeException {
    public LibraryCustomException(HttpStatus statusCode, String errorMessage) {
        super(errorMessage);
    }
}
