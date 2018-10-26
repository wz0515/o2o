package com.o2o.pojo;

import java.util.Date;

/**
 * Create By wz on 2018/10/25
 */
public class Shop {

    private Long shopId;
    private Integer userId;
    private Integer areaId;
    private Integer shopCategoryId;
    private String shopName;
    private String shopDesc;
    private String shopAddr;
    private String phone;
    private String shopImg;
    private Integer priority;
    private Integer enableStatus;
    private String advice;
    private Date createTime;
    private Date updateTime;

    public Shop() {

    }

    public Shop(Long shopId, Integer userId, Integer areaId, Integer shopCategoryId, String shopName, String shopDesc, String shopAddr, String phone, String shopImg, Integer priority, Integer enableStatus, String advice, Date createTime, Date updateTime) {
        this.shopId = shopId;
        this.userId = userId;
        this.areaId = areaId;
        this.shopCategoryId = shopCategoryId;
        this.shopName = shopName;
        this.shopDesc = shopDesc;
        this.shopAddr = shopAddr;
        this.phone = phone;
        this.shopImg = shopImg;
        this.priority = priority;
        this.enableStatus = enableStatus;
        this.advice = advice;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getShopCategoryId() {
        return shopCategoryId;
    }

    public void setShopCategoryId(Integer shopCategoryId) {
        this.shopCategoryId = shopCategoryId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    public String getShopAddr() {
        return shopAddr;
    }

    public void setShopAddr(String shopAddr) {
        this.shopAddr = shopAddr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
