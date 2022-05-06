package com.kycool.blog.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kycool.blog.response.Const;
import com.kycool.blog.response.ResponseResult;
import com.kycool.blog.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 这个类的作用是为了统一返回数据结构
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper() {
        return new ObjectMapper();
    };

    /**
     * 方法 supports 返回 true 则会执行 beforeBodyWrite 方法，否则会跳过，继续按照原来接口方法的返回值进行返回。
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(sra).getRequest();
        ResponseResult responseResult = (ResponseResult) request.getAttribute(Const.RESPONSE_RESULT_UNITY);
        // 判断返回体是否需要处理
        return responseResult != null;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        try {
            if(body instanceof Result) {
                return body;
                // return objectMapper().writeValueAsString(body);
            }
            // TODO: 这里没有搞清楚，到底有什么不同
            return objectMapper().writeValueAsString(Result.success(body));
        } catch (Exception e) {
            e.printStackTrace();
            return body;
        }
    }
}
