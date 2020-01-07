package com.hsl.quartz02.service.impl;

import com.hsl.quartz02.mapper.ScheduleTriggerParamMapper;
import com.hsl.quartz02.model.ScheduleTriggerParam;
import com.hsl.quartz02.service.ScheduleTriggerParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2020-01-04 11:59
 */
@Service
public class ScheduleTriggerParamServiceImpl implements ScheduleTriggerParamService {
    @Autowired
    private ScheduleTriggerParamMapper scheduleTriggerParamMapper;

    @Override
    public List<ScheduleTriggerParam> queryScheduleParamLst(Integer triggerId) {
        return scheduleTriggerParamMapper.queryScheduleParamLst(triggerId);
    }
}
