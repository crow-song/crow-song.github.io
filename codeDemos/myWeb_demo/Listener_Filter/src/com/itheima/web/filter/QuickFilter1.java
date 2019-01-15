package com.itheima.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class QuickFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getFilterName());
        System.out.println(filterConfig.getInitParameter("initName"));
        System.out.println("init filter");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("quick1 running");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destory filter");
    }
}
