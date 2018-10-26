package com.o2o.service.impl;

import com.o2o.dao.ShopMapper;
import com.o2o.dto.ShopExecution;
import com.o2o.enums.ShopStateEnum;
import com.o2o.exception.ShopOptException;
import com.o2o.pojo.Shop;
import com.o2o.service.IShopService;
import com.o2o.util.ImageUtil;
import com.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

/**
 * Create By wz on 2018/10/26
 */
@Service("iShopService")
@Transactional
public class ShopServiceImpl implements IShopService {

    @Autowired
    private ShopMapper shopMapper;

    public ShopExecution addShop(Shop shop, File shopImg) {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            shop.setEnableStatus(0);
            int resultCount = shopMapper.insertShop(shop);
            if (resultCount > 0) {
                if (shopImg != null) {
                    //存储店铺图片
                    addShopImg(shop, shopImg);
                    //更新店铺图片的地址
                    resultCount = shopMapper.updateShop(shop);
                    if (resultCount <= 0) {
                        throw new ShopOptException("更新店铺图片的地址失败");
                    }
                }
            } else {
                throw new ShopOptException("店铺创建失败");
            }
        } catch (Exception e) {
            throw new ShopOptException("addShop error : " + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, File shopImg) {
        //获取shop图片的相对路径
        String dest = PathUtil.getShopImgPath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnai(shopImg,dest);
        shop.setShopImg(shopImgAddr);
    }

}
