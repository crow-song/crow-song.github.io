package com.itheima.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;
//强化 request 的 getParameter 方法
public class EnhanceRequest extends HttpServletRequestWrapper{
    private HttpServletRequest request;
    //设置 map 是否进行过转码
    boolean flag=false;
    public EnhanceRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
        System.out.println("EnhanceRequest 初始化 执行");
    }
    //对 getParameter 进行增强

    @Override
    public String getParameter(String name) {
        System.out.println("EnhanceRequest getParameter 执行");
        String parameter = request.getParameter(name);//未被增强
        //获取页面提交类型
        String method = request.getMethod();
        //判断提交类型选择解码方式
//        if("POST".equals(method)){
//            try {
//                request.setCharacterEncoding("UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
        if("GET".equals(method)){
            try {
                System.out.println("get 提交");
                parameter = new String(parameter.getBytes("iso8859-1"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
            return parameter;
    }
    public Map<String, String[]> getParameterMap(){
        //获得未被增强参数方法
        Map<String,String[]> map = request.getParameterMap();
        String method = request.getMethod();
        if("GET".equals(method))
        //获得当前提交方法
        try{
            if(!flag) {
                Set<Map.Entry<String, String[]>> entries = map.entrySet();
                for (Map.Entry<String, String[]> entry : entries) {
                    String[] values = entry.getValue();
                    for (int i = 0; i < values.length; i++) {
                        values[i] = new String(values[i].getBytes("iso8859-1"), "UTF-8");
                    }
                }
                //转码过后 falg 为真，下次不再进入转码
                flag=true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return map;

    }

}
