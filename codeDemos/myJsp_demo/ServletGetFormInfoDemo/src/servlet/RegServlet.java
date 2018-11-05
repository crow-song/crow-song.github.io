package servlet;

import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegServlet", urlPatterns = "/servlet/RegServlet")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        response.setHeader("contentType", "text/html; charset=utf-8");
//        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Users u = new Users();
        String username,mypassword,email,gender,introduce;
        Date birthday;
        String[] favorite;
//        boolean isAccept;
        String isAccept;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            username = request.getParameter("username");
            mypassword = request.getParameter("mypassword");
            email = request.getParameter("email");
            gender = request.getParameter("gender");
            introduce = request.getParameter("introduce");
            birthday = sdf.parse(request.getParameter("birthday"));
            //用来获取多个复选按钮的值,返回字符串数组
            favorite = request.getParameterValues("favorite");
            isAccept = request.getParameter("isAccept");
//            if(request.getParameterValues("flag")!=null){
//                isAccept=true;
//            }
//            else{
//                isAccept=false;
//            }
//            if(isAccept.equals(true)){
//                u.setFlag(true);
//            }
//            else{
//                u.setFlag(false);
//            }

            u.setUsername(username);
            u.setMypassword(mypassword);
            u.setEmail(email);
            u.setGender(gender);
            u.setIntroduce(introduce);
            u.setBirthday(birthday);
            u.setFavorite(favorite);
            if(isAccept.equals(true)){
                u.setFlag(true);
            }
            else{
                u.setFlag(false);
            }
            //把注册成功的用户对象保存在 session 中
            request.getSession().setAttribute("regUser",u);

            //跳转到注册成功页面

            request.getRequestDispatcher("../userinfo.jsp").forward(request,response);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}