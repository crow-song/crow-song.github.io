package com.itheima.web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(name = "fileupload2Servlet", urlPatterns = "/fileupload2")
public class fileupload2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024);
            String path_temp = this.getServletContext().getRealPath("temp");
            factory.setRepository(new File(path_temp));
            ServletFileUpload upload = new ServletFileUpload(factory);

            //设置文件上传编码
            upload.setHeaderEncoding("UTF-8");
            //判断是否文件上传表单
            boolean multipartContent = upload.isMultipartContent(request);
            if (multipartContent) {
                //解析上传文件
                List<FileItem> parseRequest = null;

                parseRequest = upload.parseRequest(request);

                if (parseRequest != null) {
                    for (FileItem item : parseRequest) {
                        //判断是否普通表单项
                        if (item.isFormField()) {
                            String fieldName = item.getFieldName();
                            String string = item.getString("UTF-8");//对普通表单项内容进行编码
                            System.out.println(fieldName + ":" + string);
                        } else {
                            //文件上传
                            String fileName = item.getName();
                            //获得文件上传内容
                            InputStream inputStream = item.getInputStream();
                            String path_store = this.getServletContext().getRealPath("upload");
                            OutputStream outputStream = new FileOutputStream(path_store + "/" + fileName);
                            IOUtils.copy(inputStream, outputStream);
                            inputStream.close();
                            outputStream.close();

                        }
                    }
                }
            } else {
                //不是文件上传表单，用普通 getParameter 获得表单数据
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }
}