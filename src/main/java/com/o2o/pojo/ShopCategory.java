package com.o2o.pojo;

import java.util.Date;

/**
 * Create By wz on 2018/10/25
 */
public class ShopCategory {

    private Integer shopCategoryId;
    private Integer parentId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date updateTime;

    public ShopCategory() {
    }

    public ShopCategory(Integer shopCategoryId, Integer parentId, String shopCategoryName, String shopCategoryDesc, String shopCategoryImg, Integer priority, Date createTime, Date updateTime) {
        this.shopCategoryId = shopCategoryId;
        this.parentId = parentId;
        this.shopCategoryName = shopCategoryName;
        this.shopCategoryDesc = shopCategoryDesc;
        this.shopCategoryImg = shopCategoryImg;
        this.priority = priority;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getShopCategoryId() {
        return shopCategoryId;
    }

    public void setShopCategoryId(Integer shopCategoryId) {
        this.shopCategoryId = shopCategoryId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getShopCategoryName() {
        return shopCategoryName;
    }

    public void setShopCategoryName(String shopCategoryName) {
        this.shopCategoryName = shopCategoryName;
    }

    public String getShopCategoryDesc() {
        return shopCategoryDesc;
    }

    public void setShopCategoryDesc(String shopCategoryDesc) {
        this.shopCategoryDesc = shopCategoryDesc;
    }

    public String getShopCategoryImg() {
        return shopCategoryImg;
    }

    public void setShopCategoryImg(String shopCategoryImg) {
        this.shopCategoryImg = shopCategoryImg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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
