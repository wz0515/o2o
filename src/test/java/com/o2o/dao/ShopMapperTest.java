package com.o2o.dao;

import com.o2o.pojo.Area;
import com.o2o.pojo.Shop;
import com.o2o.pojo.ShopCategory;
import com.o2o.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create By wz on 2018/10/25
 */
public class ShopMapperTest {

    @Autowired
    private ShopMapper shopMapper;

    @Test
    public void testInsertShop(){
        Shop shop = new Shop();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        User user = new User();
        shop.setUserId(1);


    }
}
