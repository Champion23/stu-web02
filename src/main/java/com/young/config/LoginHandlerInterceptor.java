package com.young.config;

/**
 * @author 闫亮23
 * @version 1.0
 */

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取 loginUser 信息进行判断
        Object user = request.getSession().getAttribute("loginUser");
        //获取 register 信息进行判断
//        Object object = request.getSession().getAttribute("register");
        if(user == null){//未登录，返回登录页面
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }


    }
}
//        if(object == null){
//        //登录，放行
//        return true;