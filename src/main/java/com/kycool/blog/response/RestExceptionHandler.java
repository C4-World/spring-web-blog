package com.kycool.blog.response;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * 默认全局异常处理
     */
    @ExceptionHandler(Exception.class)
    public Result<String> exception(Exception e) {
        return Result.error(
                ErrorCode.INNER_ERROR.getCode(),
                e.getMessage()
        );
    }


}
