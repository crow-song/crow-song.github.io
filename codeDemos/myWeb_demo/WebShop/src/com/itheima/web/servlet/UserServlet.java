package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

public class UserServlet extends BaseServlet{


    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
//        username = new String(username.getBytes("iso8859-1"),"UTF-8");
        String password = request.getParameter("password");


        HttpSession session = request.getSession();

        UserService service = new UserService();
        User user = null;
        try {
            user = service.login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user!=null){
            //登录成功
            //判断是否勾选自动登录
            String autoLogin = request.getParameter("autoLogin");
            if(autoLogin!=null){
                //对中文张三进行编码
                String username_Code = URLEncoder.encode(username,"UTF-8");
                Cookie cookie_username = new Cookie("cookie_username",username_Code);
                Cookie cookie_password = new Cookie("cookie_password",user.getPassword());

                //设置 cookie 持久化时间
                cookie_username.setMaxAge(60*60);
                cookie_password.setMaxAge(60*60);

                //设置 cookie 携带路径
                cookie_username.setPath(request.getContextPath());
                cookie_password.setPath(request.getContextPath());
                //发送 cookie
                response.addCookie(cookie_username);
                response.addCookie(cookie_password);
            }
            //将 User 存到 Session 域

            session.setAttribute("user",user);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            request.setAttribute("loginInfo","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");

        Cookie cookie_username = new Cookie("cookie_username","");
        Cookie cookie_password = new Cookie("cookie_password","");

        //设置 cookie 持久化时间
        cookie_username.setMaxAge(0);
        cookie_password.setMaxAge(0);

        //设置 cookie 携带路径
        cookie_username.setPath(request.getContextPath());
        cookie_password.setPath(request.getContextPath());
        //发送 cookie
        response.addCookie(cookie_username);
        response.addCookie(cookie_password);

        response.sendRedirect(request.getContextPath()+"/login.jsp");

    }



}
