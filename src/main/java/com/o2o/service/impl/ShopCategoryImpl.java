package com.o2o.service.impl;

import com.o2o.dao.ShopCategoryMapper;
import com.o2o.pojo.ShopCategory;
import com.o2o.service.IShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create By wz on 2018/10/29
 */
@Service("iShopCategoryService")
@Transactional
public class ShopCategoryImpl implements IShopCategoryService {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    public List<ShopCategory> getShopCategoryList(Integer parentId) {
        return shopCategoryMapper.queryShopCategory(parentId);
    }
}
