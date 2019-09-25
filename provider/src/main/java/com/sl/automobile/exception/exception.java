package com.sl.automobile.exception;


import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by happy on 2019/8/23.
 */
@ControllerAdvice//控制器通知
public class exception {
    @ExceptionHandler(value = UnauthorizedException.class)
    public String handlerException(HttpServletRequest request,Exception e){

        return "bm_pay";
    }

}
