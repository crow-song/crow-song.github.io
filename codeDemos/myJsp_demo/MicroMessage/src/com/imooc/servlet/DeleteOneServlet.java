package com.imooc.servlet;


import com.imooc.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 单条删除控制层
 */
public class DeleteOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        //接受页面的值
        String id = req.getParameter("id");
        MaintainService maintainService = new MaintainService();
        //需要接受的参数为 int 但是判断接受的值是否为空以及转型应该在 Service 中进行
        maintainService.deleteOne(id);
        //向页面跳转 直接跳转到 list.jsp 会使得列表全部消失；列表初始化需要 listServlet 进行一些操作
        //所以应该先跳到 listServlet
//        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
        req.getRequestDispatcher("/List.action").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
