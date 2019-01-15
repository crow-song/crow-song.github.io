package com.itheima.web.filter;

import com.itheima.domain.User;
import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URLDecoder;
import java.sql.SQLException;

@WebFilter(filterName = "AutoLoginFilter",urlPatterns = "/*")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //获得 cookie 中的用户名和密码
        HttpServletRequest request = (HttpServletRequest) req;
        //增强 request 方法，使其具备解决中文乱码能力
//        EnhanceRequest enhanceRequest = new EnhanceRequest(request);
//        HttpServletResponse response = (HttpServletResponse) resp;


        //使用动态代理完成全局编码
        HttpServletRequest enhanceRequest = (HttpServletRequest)Proxy.newProxyInstance(
                req.getClass().getClassLoader(),
                req.getClass().getInterfaces(),
                new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        if("getParameter".equals(name)){
                            String invoke = (String)method.invoke(request, args);
                            invoke = new String(invoke.getBytes("iso8859-1"),"UTF-8");
                            return invoke;
                        }
                        return method.invoke(req,args);
                    }
                }
        );
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();

        String cookie_username=null;
        String cookie_password=null;
        if(cookies!=null){
            for(Cookie cookie:cookies){

                //获得名字是 cookie_username 和 cookiepassword 的 cookie 值
                if("cookie_username".equals(cookie.getName())){
                    cookie_username = cookie.getValue();
//                    把编码过的字符串变回中文
                    cookie_username = URLDecoder.decode(cookie_username, "UTF-8");
                }
                if("cookie_password".equals(cookie.getName())){
                    cookie_password=cookie.getValue();
                }
            }

        }

        //判断 username 和 password 是否为空
        if(cookie_username!=null&&cookie_password!=null){
            //登录代码
            UserService service = new UserService();
            User user = null;
            try {
                System.out.println("cookie_username="+cookie_username+" cookie_passoword="+cookie_password);
                user = service.login(cookie_username,cookie_password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //将 User 存到 Session 域
            if(user!=null){
                System.out.println("user 不为空，session name="+user.getUsername()+" session password="+user.getPassword());
                session.setAttribute("user",user);
            }
        }
        //将增强 request 参数传递给 servlet
        chain.doFilter(enhanceRequest, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
