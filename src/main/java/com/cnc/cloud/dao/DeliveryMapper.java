package com.cnc.cloud.dao;

import com.myron.db.mybatis.annotation.MyBatisRepository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@MyBatisRepository
public interface DeliveryMapper {

    @Select("select * from sys_order where status = 1 or status = 0 and deleteflag = 0")
    List<Map<String,Object>> testList();

    @Select("select reputation from sys_order where id = #{orderId};")
    Integer selectReputation(@Param("orderId")Integer orderId);

    @Select("select score from sys_order where id = #{orderId}")
    Integer selectScore(@Param("orderId")Integer orderId);

    int selectPlaceId(@Param("orderId")Integer orderId);

    @Select("select tempscore from sys_userscore where userid = #{userId}")
    int selectTempScore(@Param("userId")Integer userId);

    @Select("select grade from sys_getorder where userid = #{userId}")
    int selectGrade(@Param("userId")Integer userId);

    @Select("select count(*) from sys_orderapply where placeid = #{placeId} and userid = #{userId} and status = 2")
    int isHasGetOrder(@Param("userId")Integer userId, @Param("placeId")Integer placeId);

    @Update("update sys_order set getid = #{userId}, status = 1 where id = #{orderId}")
    void getOrder(@Param("userId")Integer userId, @Param("orderId")Integer orderId);

    @Select("select * from sys_order where getid = #{userId} and deleteflag = 0")
    List<Map<String,Object>> selectGetOrderList(@Param("userId")Integer userId);

    @Select("select * from sys_order where userid = #{userId} and deleteflag = 0")
    List<Map<String,Object>> selectPublishOrderList(@Param("userId")Integer userId);

    @Select("select score from sys_userscore where userid = #{userId}")
    Integer selectUserScore(@Param("userId")Integer userId);

    @Select("select tempscore from sys_userscore where userid = #{userId}")
    Integer selectUserTempScore(@Param("userId")Integer userId);

    @Update("update sys_userscore set tempscore = #{tempScore} where userid = #{userId}")
    void updateUserTempScore(@Param("userId")Integer userId, @Param("tempScore")Integer tempScore);

    @Select("select grade from sys_order where id = #{orderId}")
    Integer selectOrderGrade(@Param("orderId")Integer orderId);

    @Select("select ordernum from sys_getorder where userid = #{userId}")
    Integer selectOrderNum(@Param("userId")Integer userId);

    @Select("select count(1) from sys_order where getid = #{userId} and status = 1 and deleteflag = 0")
    Integer selectGetOrderNum(@Param("userId")Integer userId);

    @Update("update sys_order set status = #{status}, content = #{content} ,finishdate = now() where id = #{id}")
    void finishOrder(@Param("status")Integer status, @Param("content")String content, @Param("id")Integer id);

    @Select("update sys_userscore set score = #{score} where userid = #{userId}")
    void updateUserScore(@Param("score")Integer score,@Param("userId")Integer userId);

    @Select("select flag from sys_getorder where userid = #{userId}")
    Integer selectUserFlag(@Param("userId")Integer userId);

    @Update("update sys_getorder set grade = #{grade}, ordernum = #{orderNum} where userid = #{userId}")
    void updateGetOrderInfo(@Param("userId")Integer userId,@Param("orderNum")Integer orderNum, @Param("grade")Integer grade);

    @Insert("insert into sys_notice(title,content,createtime,creater,aim) values(#{title},#{content}, now(), 0, #{aim})")
    void insertNotice(@Param("title")String title,@Param("content")String content, @Param("aim")Integer aim);

    @Update("update sys_order set status = #{status} where id = #{orderId}")
    void updateOrderStatus(@Param("status")Integer status, @Param("orderId")Integer orderId);
}
