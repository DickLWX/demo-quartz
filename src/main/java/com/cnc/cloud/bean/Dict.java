package com.cnc.cloud.bean;



/**
 * <p>
 * 字典表
 * </p>
 *
 * @author stylefeng
 * @since 2017-07-11
 */

public class Dict  {



    /**
     * 主键id
     */
    private Integer id;
    /**
     * 排序
     */
    private Integer num;
    /**
     * 父级字典
     */
    private Integer pid;
    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;
    /**
     * 提示
     */
    private String tips;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "id=" + id +
                ", num=" + num +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", tips='" + tips + '\'' +
                '}';
    }
}
