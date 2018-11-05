package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet2", urlPatterns = "/TestServlet2",loadOnStartup = 1)
public class TestServlet2 extends HttpServlet {
    @Override
    public void destroy() {
        System.out.println("TestServlet2销毁方法被执行.....");
    }

    public TestServlet2() {
        System.out.println("TestServlet2构造方法被执行.....");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("TestServlet2初始化方法被执行.....");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TestServlet1的doPost()方法被执行.....");
//        request.setCharacterEncoding("utf-8");
        doGet(request,response);;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        System.out.println("TestServlet1的doGet()方法被执行...");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.println("<h1>大家好，我是TestServlet2！</h1>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}