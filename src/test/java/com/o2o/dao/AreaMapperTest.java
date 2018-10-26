package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.pojo.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Create By wz on 2018/10/25
 */
public class AreaMapperTest extends BaseTest {

    @Autowired
    private AreaMapper areaMapper;

    @Test
    public void testQueryArea(){
        List<Area> areaList = areaMapper.queryArea();
        Assert.assertEquals(1,areaList.size());
    }
}
