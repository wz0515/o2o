package com.o2o.controller;

import com.o2o.pojo.Area;
import com.o2o.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By wz on 2018/10/25
 */
@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private IAreaService iAreaService;

    @RequestMapping(value = "/getAreaList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAreaList(){
        Map<String,Object> areaMap = new HashMap<>();
        List<Area> areaList = iAreaService.getAreaList();
        areaMap.put("rows",areaList);
        areaMap.put("total",areaList.size());
        return areaMap;
    }
}
