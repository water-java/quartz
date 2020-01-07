package com.hsl.quartz02.mapper;

import com.hsl.quartz02.model.ScheduleTrigger;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ScheduleTriggerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScheduleTrigger record);

    int insertSelective(ScheduleTrigger record);

    ScheduleTrigger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScheduleTrigger record);

    int updateByPrimaryKey(ScheduleTrigger record);

    /**
     * 查询触发器中包含的所有任务
     * @return
     */
    List<ScheduleTrigger> queryScheduleTriggerLst();

    List<ScheduleTrigger> queryScheduleTriggerPager(ScheduleTrigger scheduleTrigger);
}