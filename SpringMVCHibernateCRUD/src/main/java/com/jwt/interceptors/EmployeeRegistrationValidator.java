/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwt.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mahendher.e
 */
public class EmployeeRegistrationValidator implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("EmployeeRegistrationValidator: preHandle:::" + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mav) throws Exception {
        System.out.println("EmployeeRegistrationValidator: preHandle:::" + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception excptn) throws Exception {
        System.out.println("EmployeeRegistrationValidator: preHandle:::" + request.getRequestURI());
    }
    
}
