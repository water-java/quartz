package com.hsl.quartz02.mapper;

import com.hsl.quartz02.model.ScheduleTriggerParam;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ScheduleTriggerParamMapper {
    int deleteByPrimaryKey(Integer param_id);

    int insert(ScheduleTriggerParam record);

    int insertSelective(ScheduleTriggerParam record);

    ScheduleTriggerParam selectByPrimaryKey(Integer param_id);

    int updateByPrimaryKeySelective(ScheduleTriggerParam record);

    int updateByPrimaryKey(ScheduleTriggerParam record);

    /**
     * 查询出当前任务类对应所需的参数
     * @param triggerId
     * @return
     */
    List<ScheduleTriggerParam> queryScheduleParamLst(Integer triggerId);
}