package com.ravionics.internship.exception;

public class UnAuthorizedAccessException extends RuntimeException {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public UnAuthorizedAccessException(String userName) {
        super();
        this.userName = userName;
    }

    public UnAuthorizedAccessException(String userName, String message) {
        super(message);
        this.userName = userName;
    }

    public UnAuthorizedAccessException(String userName, String message, Throwable cause) {
        super(message, cause);
        this.userName = userName;
    }

    public UnAuthorizedAccessException(String userName, Throwable cause) {
        super(cause);
        this.userName = userName;
    }

    protected UnAuthorizedAccessException(String userName, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.userName = userName;
    }
}
