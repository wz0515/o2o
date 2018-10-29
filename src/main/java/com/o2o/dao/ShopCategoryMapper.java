package com.o2o.dao;

import com.o2o.pojo.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Create By wz on 2018/10/28
 */
public interface ShopCategoryMapper {

    List<ShopCategory> queryShopCategory(@Param("parentId") Integer parentId);
}
