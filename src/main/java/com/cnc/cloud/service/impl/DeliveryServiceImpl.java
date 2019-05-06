package com.cnc.cloud.service.impl;

import com.cnc.cloud.dao.DeliveryMapper;
import com.cnc.cloud.service.DeliveryService;
import com.cnc.cloud.util.NoticeUtil;
import com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("deliveryService")
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryMapper deliveryMapper;

    @Override
    public void testList() {
        List<Map<String,Object>> test = deliveryMapper.testList();
        for (Map<String, Object> t : test){
            Set<String> k = t.keySet();
            for (String kk : k){
                System.out.println("--"+kk+"--"+t.get(kk));
            }
        }
    }
   // jobName.deliveryService.orderManager
    @Override
    @Transactional
    public void orderManager() {
        List<Map<String,Object>> list = deliveryMapper.testList();
        for (Map<String, Object> temp : list){
            Integer id = (Integer) temp.get("id");
            Integer status = (Integer)temp.get("status");
            Integer reputation = (Integer)temp.get("reputation");
            Integer getId = (Integer)temp.get("getid");
            Integer userId = (Integer)temp.get("userid");
            Integer score = (Integer)temp.get("score");
            Date limitDate = (Date)temp.get("limitdate");


            Integer getScore = null;
            Integer getTempScore = null;
            Integer flag = null;
            Integer orderNum = null;
            Integer grade = null;

            Integer userScore = deliveryMapper.selectUserScore(userId);
            Integer userTempScore = deliveryMapper.selectUserTempScore(userId);
            if (!Objects.equal(getId, null)) {
                getScore = deliveryMapper.selectUserScore(getId);
                getTempScore = deliveryMapper.selectTempScore(getId);
                flag = deliveryMapper.selectUserFlag(getId);
                orderNum = deliveryMapper.selectOrderNum(userId);
                grade = deliveryMapper.selectGrade(getId);
            }
            if (Objects.equal(status,1)) {
                Date currentTime = new Date();
                if (!currentTime.before(limitDate)) {
                    if (Objects.equal(flag, 0)) {
                        orderNum = getOrderNUm(grade - 5);
                    }
                    deliveryMapper.finishOrder(3, "", id);
                    deliveryMapper.updateUserScore(getScore - reputation, getId);
                    deliveryMapper.updateUserScore(userScore + reputation, userId);
                    deliveryMapper.updateUserTempScore(userId, userTempScore + reputation + score);
                    deliveryMapper.updateGetOrderInfo(getId, orderNum, grade - 5);
                    NoticeUtil.InsertNotice("订单超时", "您接订单未在最迟期限前送到", getId);
                    NoticeUtil.InsertNotice("订单超时", "您的订单已超时，以对接单人做出惩罚", userId);
                    System.out.println("订单超时执行");
                }
            }
            if (Objects.equal(status,0)){
                Date currentTime = new Date();
                if (!currentTime.before(limitDate)) {
                    deliveryMapper.updateOrderStatus(4, (Integer) temp.get("id"));
                    deliveryMapper.updateUserTempScore(userId, userTempScore + score);
                    NoticeUtil.InsertNotice("订单过期", "您的订单已过期，快去看看吧", userId);
                    System.out.println("订单过期执行");
                }
            }
        }
    }

    public static Integer getOrderNUm(Integer grade){
        if (grade < 0){
            return 0;
        }
        if (grade == 0){
            return 1;
        }
        if (grade >= 1 && grade < 5){
            return 2;
        }
        if (grade >= 5 && grade < 10){
            return 3;
        }
        if (grade >= 10 && grade < 30){
            return 4;
        }
        if (grade >= 30 && grade < 60){
            return 5;
        }
        if (grade >= 60 && grade < 100){
            return 6;
        }
        if (grade >= 100 && grade < 200){
            return 7;
        }
        if (grade >= 200 && grade < 300){
            return 8;
        }
        if (grade >= 300 && grade < 500){
            return 9;
        }
        if (grade >= 500 && grade < 1000){
            return 10;
        }
        if (grade >= 1000 && grade < 4000){
            return 11;
        }
        if (grade >= 4000 && grade < 10000){
            return 12;
        }
        return 13;
    }
}
