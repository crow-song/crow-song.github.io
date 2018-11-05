package servlet;

import com.po.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/servlet/LoginServlet")

public class LoginServlet extends HttpServlet {

//    public LoginServlet() {
//        super();
//    }
//    public void init() throws ServletException {
//        // Put your code here
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Users u = new Users();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        u.setUsername(username);
        u.setPassword(password);

        request.getSession().setAttribute("loginUser",u);

        if((u.getUsername().equals("admin")) && (u.getPassword().equals("admin")))
        {
            response.sendRedirect(request.getContextPath()+"/login_success.jsp");
        }
        else{
            response.sendRedirect(request.getContextPath()+"/login_failure.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}