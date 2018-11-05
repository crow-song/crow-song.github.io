package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestServlet", urlPatterns = "/servlet/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        请求重定向方式跳转到 test.jsp ，当前路径是 servlet/
//        response.sendRedirect("test.jsp");
//        response.sendRedirect(request.getContextPath()+"/test.jsp");
        //服务器内部跳转
        //服务器内部跳转，这里的 / 表示项目根目录
        request.getRequestDispatcher("../test.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}