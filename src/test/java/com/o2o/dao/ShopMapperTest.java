package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.pojo.Shop;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create By wz on 2018/10/25
 */
public class ShopMapperTest extends BaseTest {

    @Autowired
    private ShopMapper shopMapper;

    @Test
    public void testInsertShop(){
        Shop shop = new Shop();
        shop.setShopName("一稀饭");
        shop.setEnableStatus(0);
        int count = shopMapper.insertShop(shop);
        Assert.assertEquals(1,count);
    }
}
