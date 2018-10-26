package com.o2o.pojo;

import java.util.Date;

/**
 * Create By wz on 2018/10/25
 */
public class User {

    private Integer userId;
    private String name;
    private String profileImg; //头像
    private String email;
    private String gender;
    private Integer enableStatus;
    private Integer userType;  //1:顾客，2：店家，3：超级管理员
    private Date createTime;
    private Date updateTime;

    public User() {
    }

    public User(Integer userId, String name, String profileImg, String email, String gender, Integer enableStatus, Integer userType, Date createTime, Date updateTime) {
        this.userId = userId;
        this.name = name;
        this.profileImg = profileImg;
        this.email = email;
        this.gender = gender;
        this.enableStatus = enableStatus;
        this.userType = userType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
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
