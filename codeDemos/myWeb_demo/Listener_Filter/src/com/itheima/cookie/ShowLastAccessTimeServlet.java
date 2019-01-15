package com.itheima.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ShowLastAccessTimeServlet", urlPatterns = "/lastAccess")
public class ShowLastAccessTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
        String CurrentTime = sdf.format(new Date());
//        Cookie cookie = new Cookie("lastAccessTime",CurrentTime);
        Cookie cookie = new Cookie("lastAccessTime",CurrentTime);

        cookie.setMaxAge(60*10*500);
        response.addCookie(cookie);

        Cookie[] cookies = request.getCookies();
        String lastAccessTime = null;

        if(cookies!=null) {
            System.out.println("cookies 不为空");
            for (Cookie coo : cookies) {
                if ("lastAccessTime".equals(coo.getName())) {
                    lastAccessTime = coo.getValue();
                }
            }
        }


        response.setContentType("text/html;charset=UTF-8");
        if(lastAccessTime==null){
            response.getWriter().write("您是第一次访问");
        }else{
            response.getWriter().write("您上次访问时间是"+lastAccessTime);
        }
//


//        //获得当前时间
//        Date date = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
//        String currentTime = format.format(date);
//
//        //1、创建Cookie 记录当前的最新的访问时间
//        Cookie cookie = new Cookie("lastAccessTime",currentTime);
//        cookie.setMaxAge(60*10*500);
//        response.addCookie(cookie);
//
//        //2、获得客户端携带cookie ---- lastAccessTime
//        String lastAccessTime = null;
//        Cookie[] cookies = request.getCookies();
//        if(cookies!=null){
//            for(Cookie coo : cookies){
//                if("lastAccessTime".equals(coo.getName())){
//                    lastAccessTime = coo.getValue();
//                }
//            }
//        }
//
//        response.setContentType("text/html;charset=UTF-8");
//        if(lastAccessTime==null){
//            response.getWriter().write("您是第一次访问");
//        }else{
//            response.getWriter().write("您上次的访问的时间是："+lastAccessTime);
//        }
    }
}