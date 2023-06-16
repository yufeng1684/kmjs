package org.kmjs.interceptor;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInterceptorTimeConsume implements HandlerInterceptor {
    private NamedThreadLocal<Long> threadLocal = new NamedThreadLocal<Long>("execConsumeTime");

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("Thread.currentThread().getId() is " + Thread.currentThread().getId());
        long beginTime = System.currentTimeMillis();
        threadLocal.set(beginTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Thread.currentThread().getId() is " + Thread.currentThread().getId());
        long endTime = System.currentTimeMillis();
        long consumeTime = endTime - threadLocal.get();
        System.out.printf("请求RequestURI： %s; method = %s -> 耗时（毫秒）%s%n",
                httpServletRequest.getRequestURI(), httpServletRequest.getMethod(), consumeTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
