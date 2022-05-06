package com.kycool.blog.response;

import java.lang.annotation.*;

/**
 * 统一返回结果的自定义注解
 *
 * 目的：是为了灵活的控制返回的数据格式，有些场景需要统一，有些场景不需要统一
 *
 * 例如：
 * 1 内部业务需要统一返回数据格式
 * 2 在与第三方交互时，数据格式可能非统一
 *
 * 作用于方法和类上（接口上）
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
