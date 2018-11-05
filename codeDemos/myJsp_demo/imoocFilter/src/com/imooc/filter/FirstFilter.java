package com.imooc.filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class FirstFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init------FirstFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("start....doFilter------FirstFilter");
//        filterChain.doFilter(servletRequest,servletResponse);
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse response2 = (HttpServletResponse) servletResponse;
        //重定向
        response2.sendRedirect(req.getContextPath()+"/middle.jsp");
        //转发
//        req.getRequestDispatcher("main.jsp").forward(servletRequest,servletResponse);
        System.out.println("end....doFilter------FirstFilter");
    }

    @Override
    public void destroy() {
        System.out.println("destory------FirstFilter");
    }
}
