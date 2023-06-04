package com.hetacz.xomioposter;

public class ConnectionException extends RuntimeException {

    public ConnectionException() {
        super();
    }

    public ConnectionException(Throwable cause) {
        super(cause);
    }

    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
