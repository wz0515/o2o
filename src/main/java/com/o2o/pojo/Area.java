package com.o2o.pojo;

import java.util.Date;

/**
 * Create By wz on 2018/10/24
 */
public class Area {

    private Integer areaId;
    private String areaName;
    private Integer priority;
    private Date createTime;
    private Date updateTime;

    public Area() {
    }

    public Area(Integer areaId, String areaName, Integer priority, Date createTime, Date updateTime) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.priority = priority;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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
