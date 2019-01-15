package com.itheima.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name="GetCookieServlet",urlPatterns = "/getCookie")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            //获得 cookie 名称

            String cookieName = cookie.getName();
            if(cookieName.equals("name")) {
//                如果名称(key)等于 name 则获取其 value 值（zhangsan）
                String cookieValue = cookie.getValue();
                System.out.println(cookieValue);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);
    }
}
