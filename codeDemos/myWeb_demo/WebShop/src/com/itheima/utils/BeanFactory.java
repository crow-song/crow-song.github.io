package com.itheima.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {
    public static Object getBean(String id){
        //生产对象。根据配置文件生产，将生产细节配置到配置文件
        //使用 dom4j xml 解析技术


        try {
            //创建解析器
            SAXReader reader = new SAXReader();
            //解读文档--bean.xml
            String path = BeanFactory.class.getClassLoader().getResource("bean.xml").getPath();
            Document doc = reader.read(path);
            //获得元素
            Element element = (Element)doc.selectSingleNode("//bean[@id='" + id + "']");
            String className = element.attributeValue("class");
            //使用反射创建对象
            Class clazz = Class.forName(className);
            Object obj = clazz.newInstance();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
