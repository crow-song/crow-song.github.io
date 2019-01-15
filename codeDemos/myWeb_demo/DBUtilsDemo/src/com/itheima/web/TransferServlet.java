package com.itheima.web;

import com.itheima.service.TransferService;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "TransferServlet", urlPatterns = "/Transfer")
public class TransferServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String transfer = request.getParameter("transfer");
        String transfered = request.getParameter("transfered");
        String moneyStr = request.getParameter("money");
        double money = Double.parseDouble(moneyStr);


        TransferService service = new TransferService();
        boolean isTransferSuccess = service.transferMoney(money,transfer,transfered);

        if(isTransferSuccess){
            response.getWriter().write("转账成功");
        }else{
            response.getWriter().write("失败");
        }
    }
}