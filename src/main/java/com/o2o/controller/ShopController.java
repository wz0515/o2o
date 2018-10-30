package com.o2o.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.dto.ShopExecution;
import com.o2o.enums.ShopStateEnum;
import com.o2o.pojo.Area;
import com.o2o.pojo.Shop;
import com.o2o.pojo.ShopCategory;
import com.o2o.service.IAreaService;
import com.o2o.service.IShopCategoryService;
import com.o2o.service.IShopService;
import com.o2o.util.CodeUtil;
import com.o2o.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By wz on 2018/10/28
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private IShopService shopService;
    @Autowired
    private IShopCategoryService iShopCategoryService;
    @Autowired
    private IAreaService iAreaService;

    //跳转到店铺注册页面
    @RequestMapping(value = "/toRegister", method = RequestMethod.GET)
    public String toRegister() {
        return "shop/shopRegister.html";
    }

    @RequestMapping(value = "/getShopInitInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getShopInitInfo() {
        Map<String,Object> modelMap = new HashMap<>();
        List<ShopCategory> shopCategoryList = new ArrayList<>();
        List<Area> areaList = new ArrayList<>();
        try {
            shopCategoryList = iShopCategoryService.getShopCategoryList(1);
            areaList = iAreaService.getAreaList();
            modelMap.put("shopCategoryList",shopCategoryList);
            modelMap.put("areaList",areaList);
            modelMap.put("success",true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errorMsg",e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/registerShop", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String, Object> shopMap = new HashMap<>();
        //1.接受并转化相应的参数，包括店铺信息和图片信息
        String shopInfo = RequestUtil.getString(request, "shopInfo");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(shopInfo, Shop.class);
        } catch (IOException e) {
            shopMap.put("success", false);
            shopMap.put("errorMsg", e.getMessage());
            return shopMap;
        }
        //处理图片信息
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        //判断是否有文件流
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");  //参数“shopImg”从前端传来
        }
        //2.注册店铺
        if (shop != null && shopImg != null) {
            shop.setUserId(1);
            ShopExecution se = null;
            try {
                se = shopService.addShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }

            if (se.getState() == ShopStateEnum.CHECK.getState()) {
                shopMap.put("succrss", true);
            } else {
                shopMap.put("success", false);
                shopMap.put("errorMsg", se.getStateInfo());
            }

            //验证码
            if (!CodeUtil.checkVerifyCode(request)) {
                shopMap.put("success",false);
                shopMap.put("eroorMsg","验证码错误");
            }
            return shopMap;

        } else {
            shopMap.put("success", false);
            shopMap.put("errorMsg", "请输入店铺信息");
            return shopMap;
        }
    }
}
