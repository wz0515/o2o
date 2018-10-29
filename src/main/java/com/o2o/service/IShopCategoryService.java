package com.o2o.service;

import com.o2o.pojo.ShopCategory;

import java.util.List;

/**
 * Create By wz on 2018/10/29
 */
public interface IShopCategoryService {

    List<ShopCategory> getShopCategoryList(Integer parentId);
}
