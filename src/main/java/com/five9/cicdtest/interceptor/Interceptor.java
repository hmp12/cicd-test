package com.five9.cicdtest.interceptor;

import com.five9.cicdtest.entity.UserEntity;
import com.five9.cicdtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Interceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String username = request.getHeader("Username");
        String passsword = request.getHeader("Password");
        String role = request.getHeader("role");

        UserEntity user = userService.getUserByUsername(username);

//        if (user == null || !user.getPassword().equals(passsword)) {
//            System.out.println("Wrong user");
//            return false;
//        }
//
//        if (role.equals("1")) {
//            System.out.println("Hello admin");
//            return true;
//        }
//
//        if (role.equals("3") && !method.equals("GET")) {
//            System.out.println("Denied");
//            return false;
//        }
//
//        if (role.equals("2") && (method.equals("GET") || method.equals("DELETE"))) {
//            System.out.println("Denied");
//            return false;
//        }

        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
    }
}