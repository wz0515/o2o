package com.o2o.enums;

/**
 * Create By wz on 2018/10/26
 */
public enum ShopStateEnum {
    CEHCK(0, "审核中"),
    OFFLINE(-1, "非法店铺"),
    SUCCESS(1, "操作成功"),
    PASS(2, "通过认证"),
    INNER_ERROR(-2, "系统内部错误");

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    private ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    //依据传入的state返回相应的enum值
    public static ShopStateEnum getEnum(int state) {
        for (ShopStateEnum shopStateEnum : values()) {
            if (state == shopStateEnum.getState())
                return shopStateEnum;
        }
        return null;
    }
}
