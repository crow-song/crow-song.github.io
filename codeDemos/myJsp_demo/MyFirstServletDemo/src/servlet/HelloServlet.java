package servlet;

import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("处理get请求....");
        PrintWriter out = resp.getWriter();
//      使 html 代码生效，不然会直接输出 html 代码
        resp.setContentType("text/html;charset=utf-8");
        out.println("<strong>Hello</strong> <br> servlet! ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("处理post请求....");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        out.println("<strong>Hello</strong> <br> servlet! ");
    }

}
