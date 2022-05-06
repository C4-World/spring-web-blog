package com.kycool.blog.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private int status;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setStatus(ErrorCode.SUCCESS.getCode());
        result.setMessage(ErrorCode.SUCCESS.getMessage());
        return result;
    }

    public static <T> Result<T> error(int code, String message) {
        Result<T> result = new Result<>();
        result.setStatus(code);
        result.setMessage(message);
        return result;
    }
}
