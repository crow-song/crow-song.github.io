package com.itheima.domain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PersonBindingServlet", urlPatterns = "/PersonBindingServlet")
public class PersonBindingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        //将 person 对象绑定到 session 中
        Person person = new Person();
        person.setId("100");
        person.setName("lucy");
        session.setAttribute("ren",person);

        //将 person 对象 从 session 中解绑
        session.removeAttribute("ren");
    }
}