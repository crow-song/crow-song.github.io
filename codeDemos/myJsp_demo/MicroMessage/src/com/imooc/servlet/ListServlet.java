package com.imooc.servlet;

import com.imooc.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 列表页面初始化控制
 */
@WebServlet(name="ListServlet" ,urlPatterns = "/List.action")
public class ListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        //接受页面的值
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        //向页面传值
        req.setAttribute("command",command);
        req.setAttribute("description",description);
        //查询消息列表并传给页面。调用 ListService 的函数，将查询的结果放到 req 中
        QueryService queryService = new QueryService();
        req.setAttribute("messageList", queryService.queryMessageList(command,description));
        //向页面跳转
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
