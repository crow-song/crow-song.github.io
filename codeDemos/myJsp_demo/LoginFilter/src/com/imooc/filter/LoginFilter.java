package com.imooc.filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter{


    private FilterConfig config;
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();


        String noLoginPaths = config.getInitParameter("noLoginPaths");
        String charset = config.getInitParameter("charset");
        if(charset==null){
            charset="UTF-8";
        }
        request.setCharacterEncoding(charset);

        if(noLoginPaths!=null){
            String [] strArray = noLoginPaths.split(";");
            for(int i=0; i<strArray.length; i++){
                if(strArray[i] == null || "".equals(strArray[i]))continue;
                if(request.getRequestURI().indexOf(strArray[i])!=-1)

                {
                    filterChain.doFilter(servletRequest,servletResponse);
                    return;
                }

            }
        }
//        if(request.getRequestURI().indexOf("login.jsp")!=-1 ||
//                request.getRequestURI().indexOf("LoginServlet")!=-1 ||
//                request.getRequestURI().indexOf("failure.jsp")!=-1
//       )
//
//        {
//            filterChain.doFilter(servletRequest,servletResponse);
//            return;
//        }

        if(session.getAttribute("username")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else{
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
