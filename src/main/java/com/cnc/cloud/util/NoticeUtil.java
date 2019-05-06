package com.cnc.cloud.util;


import com.cnc.cloud.dao.DeliveryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoticeUtil {


    private static DeliveryMapper DeliveryMapper;

    @Autowired
    public void setDeliveryMapper(DeliveryMapper DeliveryMapper) {
        this.DeliveryMapper = DeliveryMapper;
    }

    public static void InsertNotice(String title, String content, Integer aim){
        DeliveryMapper.insertNotice(title, content, aim);
    }
}
