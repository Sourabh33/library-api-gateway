package com.app.libraryapigateway.exception;

public class ErrorMessage {

    private String timeStamp;
    private String message;
    private Integer statusCode;

    public ErrorMessage(String timeStamp, String message, Integer statusCode) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
