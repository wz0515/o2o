package com.o2o.service;

import com.o2o.dto.ShopExecution;
import com.o2o.pojo.Shop;

import java.io.File;

/**
 * Create By wz on 2018/10/26
 */
public interface IShopService {

    ShopExecution addShop(Shop shop, File shopImg);
}
