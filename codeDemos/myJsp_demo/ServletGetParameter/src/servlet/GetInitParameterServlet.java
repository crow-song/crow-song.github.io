package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//用注解完成 Servlet 初始化
@WebServlet(name = "GetInitParameterServlet", urlPatterns = "/servlet/GetInitParameterServlet",
        initParams = {
        @WebInitParam(name="username",value="kiraki"),
        @WebInitParam(name="password",value="66666")
        })
public class GetInitParameterServlet extends HttpServlet {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void init() throws ServletException {
        this.setUsername(this.getInitParameter("username"));
        this.setPassword(this.getInitParameter("password"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(this.getUsername());
        response.getWriter().println(this.getPassword());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}