package com.kycool.blog.response;

public enum ErrorCode {
    SUCCESS(0, ""),
    INNER_ERROR(10000, "内部错误");


    // 定义状态
    private final int code;
    // 错误描述
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
