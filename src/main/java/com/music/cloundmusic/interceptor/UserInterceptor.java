package com.music.cloundmusic.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("userMsg")==null){
            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) { //如果是ajax请求响应头会有x-requested-with
                //System.out.println("ajax请求被拦截");
                response.getWriter().print("did not login");
                return false;
            }else {
                request.getSession().setAttribute("errorMsg","访问错误");
                request.getSession().setAttribute("errorURL",request.getRequestURI());
                response.sendRedirect("/errorPage");
                return false;
            }
        }
        return true;
    }
}
