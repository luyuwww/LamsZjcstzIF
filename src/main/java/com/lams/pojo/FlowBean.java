package com.lams.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class FlowBean implements Serializable {
    private static final long serialVersionUID = 7803316686165670002L;
    //条目的did集合
    private String dids;
    //申请人部门
    private String sqrbm;
    //申请数据全宗号
    private String sqsjqzh;
    //扩展字段
    private String extendfield;
    private String approvalResult;
    //申请人代码
    private String sqrdm;
    //申请人姓名
    private String sqrxm;
    //申请类型
    private String sqtype;
    private String applyUserId;
    //申请缘由
    private String sqyy;
    //档案类型号
    private String libcode;
    //表名
    private String tablename;//无实际用处
    //申请人密集
    private String sqrmj;
    //是否显示grid
    private String isshowgrid;
    //申请日期
    private String sqrq;
    //申请人全宗号
    private String sqrqzh;
    private String recentOperator;
    //申请说明
    private String sqsm;
    //密集
    private String mj;
    //审批结果
    private String spjg;
    //利用目的
    private String lymd;
    //利用方式 次数/时间
    private String timeortimes;
    //次数方式才有值 否则为-1 申请次数
    private Integer times;
    //时间方式才有值 否则为空 开始时间
    private String startime;
    //时间方式才有值 否则为空 结束时间
    private String endtime;

    private String OutSystemFqrCode;
    private List<Map<String, Object>> dataList;

    public String getLymd() {
        return lymd;
    }

    public void setLymd(String lymd) {
        this.lymd = lymd;
    }

    public String getDids() {
        return dids;
    }

    public void setDids(String dids) {
        this.dids = dids;
    }

    public String getSqrbm() {
        return sqrbm;
    }

    public void setSqrbm(String sqrbm) {
        this.sqrbm = sqrbm;
    }

    public String getSqsjqzh() {
        return sqsjqzh;
    }

    public void setSqsjqzh(String sqsjqzh) {
        this.sqsjqzh = sqsjqzh;
    }

    public String getExtendfield() {
        return extendfield;
    }

    public void setExtendfield(String extendfield) {
        this.extendfield = extendfield;
    }

    public String getApprovalResult() {
        return approvalResult;
    }

    public void setApprovalResult(String approvalResult) {
        this.approvalResult = approvalResult;
    }

    public String getSqrdm() {
        return sqrdm;
    }

    public void setSqrdm(String sqrdm) {
        this.sqrdm = sqrdm;
    }

    public String getSqtype() {
        return sqtype;
    }

    public void setSqtype(String sqtype) {
        this.sqtype = sqtype;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getSqyy() {
        return sqyy;
    }

    public void setSqyy(String sqyy) {
        this.sqyy = sqyy;
    }

    public String getLibcode() {
        return libcode;
    }

    public void setLibcode(String libcode) {
        this.libcode = libcode;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getSqrxm() {
        return sqrxm;
    }

    public void setSqrxm(String sqrxm) {
        this.sqrxm = sqrxm;
    }

    public String getSqrmj() {
        return sqrmj;
    }

    public void setSqrmj(String sqrmj) {
        this.sqrmj = sqrmj;
    }

    public String getIsshowgrid() {
        return isshowgrid;
    }

    public void setIsshowgrid(String isshowgrid) {
        this.isshowgrid = isshowgrid;
    }

    public String getSqrq() {
        return sqrq;
    }

    public void setSqrq(String sqrq) {
        this.sqrq = sqrq;
    }

    public String getSqrqzh() {
        return sqrqzh;
    }

    public void setSqrqzh(String sqrqzh) {
        this.sqrqzh = sqrqzh;
    }

    public String getRecentOperator() {
        return recentOperator;
    }

    public void setRecentOperator(String recentOperator) {
        this.recentOperator = recentOperator;
    }

    public String getSqsm() {
        return sqsm;
    }

    public void setSqsm(String sqsm) {
        this.sqsm = sqsm;
    }

    public String getMj() {
        return mj;
    }

    public void setMj(String mj) {
        this.mj = mj;
    }

    public String getSpjg() {
        return spjg;
    }

    public void setSpjg(String spjg) {
        this.spjg = spjg;
    }

    public String getOutSystemFqrCode() {
        return OutSystemFqrCode;
    }

    public void setOutSystemFqrCode(String outSystemFqrCode) {
        OutSystemFqrCode = outSystemFqrCode;
    }

    public List<Map<String, Object>> getDataList() {
        return dataList;
    }

    public void setDataList(List<Map<String, Object>> dataList) {
        this.dataList = dataList;
    }

    public String getTimeortimes() {
        return timeortimes;
    }

    public void setTimeortimes(String timeortimes) {
        this.timeortimes = timeortimes;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getStartime() {
        return startime;
    }

    public void setStartime(String startime) {
        this.startime = startime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
