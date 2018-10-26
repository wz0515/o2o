package com.o2o.service.impl;

import com.o2o.dao.AreaMapper;
import com.o2o.pojo.Area;
import com.o2o.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create By wz on 2018/10/25
 */
@Transactional
@Service("iAreaService")
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private AreaMapper areaMapper;

    public List<Area> getAreaList(){
        return areaMapper.queryArea();
    }

}
