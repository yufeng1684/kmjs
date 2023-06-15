package org.yufeng.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.yufeng.domain.ResultBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class CustomExceptionResolver implements HandlerExceptionResolver {
    protected static final String DEFAULT_ERRORMESSAGE = "系统忙，请稍后再试";
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String errorMsg = e instanceof CustomException ? e.getMessage():DEFAULT_ERRORMESSAGE;
        String exStack = Throwables.getStackTraceAsString(e);
        System.out.printf("Request: %s raise %s", httpServletRequest.getRequestURI(), exStack);
        ModelAndView modelAndView = null;
        if(httpServletRequest.getHeader("x-requested-with") != null &&
                httpServletRequest.getHeader("x-requested-with") .equalsIgnoreCase("XMLHttpRequest")) {
            modelAndView = handleAjaxError(httpServletResponse, errorMsg);
        }else{
            modelAndView = handleViewError(httpServletRequest.getRequestURI(), e.getMessage(), "error");
        }
        return modelAndView;
    }

    protected ModelAndView handleViewError(String url, String errorMessage, String viewName) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("url", url);
        // 将错误信息传到页面
        mav.addObject("message", errorMessage);
        // 指向错误页面
        mav.setViewName(viewName);
        return mav;
    }

    protected ModelAndView handleAjaxError(HttpServletResponse rsp, String errorMessage) {
        try {
            rsp.setCharacterEncoding("UTF-8");
            rsp.setContentType("application/json;charset=utf-8");
            rsp.setStatus(HttpStatus.OK.value());
            PrintWriter writer = rsp.getWriter();
            ResultBean bean = ResultBean.ofFail(500, errorMessage);
            ObjectMapper mapper = new ObjectMapper();
            // ResultBean类转JSON
            String json = mapper.writeValueAsString(bean);
            System.out.println(json);

            writer.write(json);// 输出
            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
