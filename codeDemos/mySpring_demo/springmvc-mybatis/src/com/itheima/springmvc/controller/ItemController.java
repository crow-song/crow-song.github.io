package com.itheima.springmvc.controller;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品管理
 *
 */
@Controller
public class ItemController {

    //注入 ItemServicce
    @Autowired
    private ItemService itemService;
    //入门程序
    @RequestMapping(value="/item/itemlist.action")
    public ModelAndView itemList(){
       //从 mysql 中查询 list
        List<Items> list = itemService.selectItemsList();

        ModelAndView mav = new ModelAndView();
        //数据
        mav.addObject("itemList",list);
//        mav.setViewName("/WEB-INF/jsp/itemList.jsp");
        //可以在 springmvc.xml 中拼接完整地址 ，也可以直接写完整，（查询列表地址）
        mav.setViewName("itemList");
        return mav;
    }

    //修改页面入参 id
    @RequestMapping(value="/itemEdit.action")
    public ModelAndView toEdit(Integer id,HttpServletRequest request, HttpServletResponse response
            , HttpSession session, Model model){
        //servlet 开发
//        String id = request.getParameter("id");

        //查询一个商品
//        Items items = itemService.selectItemsById(Integer.parseInt(id));
        Items items = itemService.selectItemsById(id);


        ModelAndView mav = new ModelAndView();
        //与 editltem.jsp 的 value 对应
        mav.addObject("item",items);
        //返回给用户的（修改）视图界面地址，与 springmvc.xml 中拼接完整
        mav.setViewName("editItem");
        return mav;
    }

    //提交修改页面 入参 为 Items 对象
    @RequestMapping(value="/updateitem.action")
//    public ModelAndView updateitem(Items items){
        public ModelAndView updateitem(QueryVo vo){
        //修改
//        itemService.updateItemsById(items);
        itemService.updateItemsById(vo.getItems());
        ModelAndView mav = new ModelAndView();
        //修改完后跳转到成功视图
        mav.setViewName("success");
        return mav;
    }

}
