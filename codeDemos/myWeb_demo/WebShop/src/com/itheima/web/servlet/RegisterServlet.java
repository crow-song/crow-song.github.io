package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.CommonsUtils;
import com.itheima.utils.MailUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");// 处理post请求乱码问题
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");// 处理post请求乱码问题
        response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
        // str = new String(str.getBytes("ISO-8859-1"), "UTF-8");   // 处理get请求乱码问题

        //获得表单数据
        Map<String,String[]> parameter = request.getParameterMap();
        User user = new User();

        //自己设置一个转换器，将 String 转成 Date
            ConvertUtils.register(new Converter() {
                @Override
                public Object convert(Class aClass, Object o) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date parse = null;
                    try {
                        parse = format.parse(o.toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    return parse;
                }
            },Date.class);
        try {
            BeanUtils.populate(user,parameter);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //从 CommonsUtils 取得表单中没有的数据
        //UUID
        user.setUid(CommonsUtils.getUUID());
        user.setTelephone(null);
        user.setState(0);
        //激活码
        String activeCode = CommonsUtils.getUUID();
        user.setCode(activeCode);

        UserService service = new UserService();
        boolean isRegisterSuccess = service.register(user);

        //判断注册成功
        if(isRegisterSuccess){
            //发送激活邮件
            String eMsg = "恭喜注册成功，请点击连接进行激活" +
                    "<a href='http://localhost:8080/WebShop/active?activeCode="+activeCode+"'>" +
                    "href='http://localhost:8080/WebShop/active?activeCode="+activeCode+"</a>";

            try {
                MailUtils.sendMail(user.getEmail(),eMsg);
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            response.sendRedirect(request.getContextPath() + "/registerSuccess.jsp");
        }else{
            response.sendRedirect(request.getContextPath() + "/registerFail.jsp");
        }

    }
}
