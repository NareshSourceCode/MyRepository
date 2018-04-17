/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwt.interceptors;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mahendher.e
 */
public class RequestAuthenticator implements HandlerInterceptor {//HandlerInterceptorAdapter 
//for validate from repositary or dao
//    @Autowired
//    private MyRepository myRepository;

//    
//    prehandle() – called before the actual handler is executed, but the view is not generated yet
//postHandle() – called after the handler is executed
//afterCompletion() – called after the complete request has finished and view was generated
//    
//    
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("RequestAuthenticator: preHandle:::" + request.getRequestURI());

//        Map pathVariables = getUrlPathVariables(request);
//        String myId = (String) pathVariables.get("myId"); // e.g. /rest/path/${myParam}
//
////        if (myId != null && myRepository.findById(myId) == null) {
////            throw new RuntimeException("My Object not found");
////        }
//
//
//
//
//        //get session from request
//        HttpSession session = request.getSession();
//        System.out.println(session.getAttribute("loginUser"));
//
//        //check if user already have set attribute userLogin
//        if (session.getAttribute("userLogin") != null) {
//            return true;
//        }
//
//        String[] splitURI = request.getRequestURI().split("/");
//        if (splitURI[splitURI.length - 1].equals("login")) {
//            return true;
//        }
//
//        //if user is not logged in we redirect him to login
//        System.out.println("redirect to secure/login");
//        response.sendRedirect("newEmployee");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mav) throws Exception {
        System.out.println("RequestAuthenticator: postHandle:::" + request.getRequestURI());

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception excptn) throws Exception {
        System.out.println("RequestAuthenticator: afterCompletion:::" + request.getRequestURI());
    }

    private Map getUrlPathVariables(HttpServletRequest request) {
        return (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    }
}
