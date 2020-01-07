package com.hsl.quartz02.service.impl;

import com.hsl.quartz02.mapper.ScheduleTriggerMapper;
import com.hsl.quartz02.model.ScheduleTrigger;
import com.hsl.quartz02.service.ScheduleTriggerService;
import com.hsl.quartz02.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2020-01-05 19:05
 */
@Service
public class ScheTriggerServiceImpl implements ScheduleTriggerService {

    @Autowired
    ScheduleTriggerMapper scheduleTriggerMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return scheduleTriggerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ScheduleTrigger record) {
        return scheduleTriggerMapper.insert(record);
    }

    @Override
    public int insertSelective(ScheduleTrigger record) {
        return 0;
    }

    @Override
    public ScheduleTrigger selectByPrimaryKey(Integer id) {
        return scheduleTriggerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ScheduleTrigger record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ScheduleTrigger record) {
        return scheduleTriggerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ScheduleTrigger> queryScheduleTriggerPager(ScheduleTrigger scheduleTrigger, PageBean pageBean) {
        return scheduleTriggerMapper.queryScheduleTriggerPager(scheduleTrigger);
    }
}
