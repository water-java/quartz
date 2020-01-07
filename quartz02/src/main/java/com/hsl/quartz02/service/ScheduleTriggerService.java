package com.hsl.quartz02.service;

import com.hsl.quartz02.model.ScheduleTrigger;
import com.hsl.quartz02.util.PageBean;

import java.util.List;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2020-01-04 11:57
        */
public interface ScheduleTriggerService {
    int deleteByPrimaryKey(Integer id);

    int insert(ScheduleTrigger record);

    int insertSelective(ScheduleTrigger record);

    ScheduleTrigger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScheduleTrigger record);

    int updateByPrimaryKey(ScheduleTrigger record);

    List<ScheduleTrigger> queryScheduleTriggerPager(ScheduleTrigger scheduleTrigger, PageBean pageBean);

}
