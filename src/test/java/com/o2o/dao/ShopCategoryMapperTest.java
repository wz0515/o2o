package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.pojo.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Create By wz on 2018/10/29
 */
public class ShopCategoryMapperTest extends BaseTest {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    @Test
    public void queryShopCategoryTest(){
        List<ShopCategory> shopCategoryList = shopCategoryMapper.queryShopCategory(1);
        Assert.assertEquals(1,shopCategoryList.size());
    }
}
