package com.kycool.blog.response;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 定义返回结果拦截器
 *
 * 如果类或者方法使用了 ResponseResult 注解，则设置对应的属性值，供响应类调用，即 ResponseAdvice
 */

public class ResponseResultInterceptor implements HandlerInterceptor {

    // 统一的返回体标识
    private static final String RESPONSE_RESULT_UNITY = Const.RESPONSE_RESULT_UNITY;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("拦截器 ResponseResultInterceptor 的 preHandle 方法开始执行");
        if(handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;

            // 获取当前类
            final Class<?> cls = handlerMethod.getBeanType();
            // 获取当前方法
            final Method method = handlerMethod.getMethod();
            // 判断类上是否使用了注解
            if(cls.isAnnotationPresent(ResponseResult.class)) {
                // 设置该请求返回体，需要包装，往下传递，在 ResponseAdvice 类中进行判断
                request.setAttribute(Const.RESPONSE_RESULT_UNITY, cls.getAnnotation(ResponseResult.class));
            }
            // 判断方法上是否使用了注解
            else if(method.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(Const.RESPONSE_RESULT_UNITY, method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器 ResponseResultInterceptor 的 postHandle 方法开始执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("拦截器 ResponseResultInterceptor 的 afterCompletion 方法开始执行");
    }

}
