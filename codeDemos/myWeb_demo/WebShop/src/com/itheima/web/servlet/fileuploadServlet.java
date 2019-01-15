package com.itheima.web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
@WebServlet(name="fileuploadServlet",urlPatterns = "fileupload")
public class fileuploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");// 处理post请求乱码问题
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");// 处理post请求乱码问题
        response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
        // str = new String(str.getBytes("ISO-8859-1"), "UTF-8");   // 处理get请求乱码问题

        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> parseRequest = upload.parseRequest(request);
            for(FileItem fileItem : parseRequest){
                boolean formField = fileItem.isFormField();
                if(formField){
                    String fieldName = fileItem.getFieldName();
                    String string = fileItem.getString();
                    System.out.println(fieldName+":"+string);
                }else{
                    String name = fileItem.getName();
                    InputStream inputStream = fileItem.getInputStream();
                    System.out.println(name+":"+inputStream);

                    String path=this.getServletContext().getRealPath("upload");
                    OutputStream out = new FileOutputStream(path+"/"+name);

                    int len=0;
                    byte [] buffer = new byte[1024];
                    while((len=inputStream.read(buffer))>0){
                        out.write(buffer,0,len);
                    }
                    inputStream.close();
                    out.close();

                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
