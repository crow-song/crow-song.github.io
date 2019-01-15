package com.itheima.web.filter;

import com.itheima.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginPrivilegeFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //判断用户是否登陆，如果未登录则不封装Order
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user==null){
            //没有登陆则跳回登录页
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            //防止跳转后后面代码执行
            return;
        }


        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
