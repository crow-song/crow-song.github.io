package com.itheima.springmvc.conversion;

import javafx.scene.input.DataFormat;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 转换日期类型的数据
 * Converter<页面传递过来的类型，转换后的类型>
 */

public class DateConveter implements Converter<String,Date>{
    @Override
    public Date convert(String source) {
        try{
            if(null != source){//2222:11-12 11_44-50  2018:11-12 14_24-17
                SimpleDateFormat df = new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
                return df.parse(source);
            }
        }catch(Exception e){

        }
        return null;
    }
}
