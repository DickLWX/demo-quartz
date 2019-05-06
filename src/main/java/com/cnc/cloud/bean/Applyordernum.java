package com.cnc.cloud.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 接单人申请接单数表
 * </p>
 *
 * @author stylefeng
 * @since 2019-03-26
 */

public class Applyordernum  {

    private static final long serialVersionUID = 1L;

    /**
     * 接单人申请接单数申请表主键id
     */
    private Integer id;
    /**
     * 申请人id
     */
    private Integer userid;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 申请接单数
     */
    private Integer applynum;
    /**
     * 审核人id
     */
    private Integer adminid;
    /**
     * 审核状态0：未通过 1：通过
     */
    private Integer status;
    /**
     * 申请时间
     */
    private Date createdate;
    /**
     * 审核时间
     */
    private Date reviewdate;
    /**
     * 删除标记0：未删除 1:删除
     */
    private Integer deleteflag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getApplynum() {
        return applynum;
    }

    public void setApplynum(Integer applynum) {
        this.applynum = applynum;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getReviewdate() {
        return reviewdate;
    }

    public void setReviewdate(Date reviewdate) {
        this.reviewdate = reviewdate;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }

    @Override
    public String toString() {
        return "Applyordernum{" +
        ", id=" + id +
        ", userid=" + userid +
        ", mobile=" + mobile +
        ", applynum=" + applynum +
        ", adminid=" + adminid +
        ", status=" + status +
        ", createdate=" + createdate +
        ", reviewdate=" + reviewdate +
        ", deleteflag=" + deleteflag +
        "}";
    }
}
