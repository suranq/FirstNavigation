package com.example.firstnavigation.https;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public class ApiException extends Throwable{
    private int code;
    private String message;

    public ApiException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiException(String message, int code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public ApiException(String message, Throwable cause, int code, String message1) {
        super(message, cause);
        this.code = code;
        this.message = message1;
    }

    public ApiException(Throwable cause, int code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message1;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
