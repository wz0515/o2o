package com.o2o.dto;

import com.o2o.enums.ShopStateEnum;
import com.o2o.pojo.Shop;

import java.util.List;

/**
 * Create By wz on 2018/10/26
 */
public class ShopExecution {

    private int state;  //结果状态
    private String stateInfo;  //状态信息
    private int count;   //店铺数量
    private Shop shop;
    private List<Shop> shopList;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public ShopExecution() {

    }

    public ShopExecution(ShopStateEnum shopStateEnum) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
    }

    public ShopExecution(ShopStateEnum shopStateEnum, Shop shop) {
        this(shopStateEnum);
        this.shop = shop;
    }

    public ShopExecution(ShopStateEnum shopStateEnum, List<Shop> shopList) {
        this(shopStateEnum);
        this.shopList = shopList;
    }
}
