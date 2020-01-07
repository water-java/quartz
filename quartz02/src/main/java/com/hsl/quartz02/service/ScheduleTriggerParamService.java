package com.hsl.quartz02.service;

import com.hsl.quartz02.model.ScheduleTriggerParam;

import java.util.List;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2020-01-04 11:57
        */
public interface ScheduleTriggerParamService {
    public List<ScheduleTriggerParam> queryScheduleParamLst(Integer triggerId);


}
