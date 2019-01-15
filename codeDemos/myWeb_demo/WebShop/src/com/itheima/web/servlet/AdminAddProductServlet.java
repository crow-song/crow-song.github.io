package com.itheima.web.servlet;

import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.service.AdminService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.CommonsUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminAddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");// 处理post请求乱码问题
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");// 处理post请求乱码问题
        response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
        try {
            Product product = new Product();
            //收集数据的容器
            Map<String, Object> map = new HashMap<String, Object>();
            //收集表单数据，封装成实体，传递给 service ，将上传的图片保存到磁盘
            //创建磁盘文件项
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //创建文件上传核心对象
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解析 request 获得文件项对象集合
            List<FileItem> parseRequest = upload.parseRequest(request);
            //判断是否多表单
            boolean multipartContent = upload.isMultipartContent(request);
            if (multipartContent) {
                for (FileItem item : parseRequest) {
                    //判断是否是普通表单项
                    boolean formField = item.isFormField();
                    if (formField) {
                        //是普通表单项，获得表单的数据，封装到实体中
                        String fieldName = item.getFieldName();
                        //获取 UTF-8 格式的内容
                        String fieldValue = item.getString("UTF-8");
                        map.put(fieldName, fieldValue);

                    } else {
                        //是文件上传项，获得文件名称和内容
                        String fileName = item.getName();
                        InputStream in = item.getInputStream();
                        String path = this.getServletContext().getRealPath("upload");
                        System.out.println(path + "/" + fileName);
                        OutputStream out = new FileOutputStream(path + "/" + fileName);
                        IOUtils.copy(in, out);
                        in.close();
                        out.close();

                        map.put("pimage","upload/"+fileName);
                    }
                }

                BeanUtils.populate(product, map);
//                private String pid;
                product.setPid(CommonsUtils.getUUID());
//                private String pimage;
//                private Date pdate;
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                String format = formatter.format(new Date());
//                .parse(new Date().toString());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                Date date = new Date();
                String format = simpleDateFormat.format(new Date());
                Date parse = simpleDateFormat.parse(format);

                product.setPdate(parse);
//                private int    pflag;
                product.setPflag(0);


//                private Category category;-->cid
                Category category = new Category();
                category.setCid(map.get("cid").toString());
                product.setCategory(category);

                //将封装好的 product 传递到 service
                AdminService service = (AdminService) BeanFactory.getBean("adminService");
                service.saveProduct(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
