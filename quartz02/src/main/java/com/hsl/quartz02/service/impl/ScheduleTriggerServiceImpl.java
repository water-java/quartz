package com.hsl.quartz02.service.impl;

import com.hsl.quartz02.mapper.ScheduleTriggerMapper;
import com.hsl.quartz02.mapper.ScheduleTriggerParamMapper;
import com.hsl.quartz02.model.ScheduleTrigger;
import com.hsl.quartz02.model.ScheduleTriggerParam;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2020-01-04 11:57
 */
@Service
public class ScheduleTriggerServiceImpl {
    @Autowired
    private ScheduleTriggerMapper scheduleTriggerMapper;

    @Autowired
    private ScheduleTriggerParamMapper scheduleTriggerParamMapper;

    @Autowired
    private Scheduler scheduler;

    @Scheduled(cron = "0/10 * * * * ?")
    public void refreshScheduler() {
        try {
            List<ScheduleTrigger> scheduleTriggers = scheduleTriggerMapper.queryScheduleTriggerLst();
            if (null != scheduleTriggers) {
                for (ScheduleTrigger scheduleTrigger : scheduleTriggers) {
                    String cron = scheduleTrigger.getCron();//表达式
                    String jobName = scheduleTrigger.getJob_name();//任务名称
                    String jobGroup = scheduleTrigger.getJob_group();//任务分组
                    String status = scheduleTrigger.getStatus();//任务状态
                    //根据jobName和jobGroup生成TriggerKey
                    TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
                    //根据TriggerKey到Scheduler调度器中获取触发器
                    CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
                    if (null == cronTrigger) {
                        if (status.equals("0"))
                            continue;
//                        只执行一次
                        System.out.println("创建调度器");
                        //创建任务详情
                        JobDetail jobDetail = JobBuilder
                                .newJob((Class<? extends Job>) Class.forName(jobName))
                                .withIdentity(jobName, jobGroup)
                                .build();

                        //往Job 任务中传递参数
                        JobDataMap jobDataMap = jobDetail.getJobDataMap();
                        List<ScheduleTriggerParam> scheduleTriggerParams = scheduleTriggerParamMapper.queryScheduleParamLst(scheduleTrigger.getId());
                        for (ScheduleTriggerParam scheduleTriggerParam : scheduleTriggerParams) {
                            jobDataMap.put(scheduleTriggerParam.getName(), scheduleTriggerParam.getValue());
                        }
//创建表达式调度器
                        CronScheduleBuilder cronSchedule =
                                CronScheduleBuilder.cronSchedule(cron);

                        //创建Trigger
                        cronTrigger = TriggerBuilder.newTrigger()
                                .withIdentity(jobName, jobGroup)
                                .withSchedule(cronSchedule)
                                .build();

                        //将jobDetail和Trigger注入到scheduler调度器中
                        scheduler.scheduleJob(jobDetail, cronTrigger);
                    } else {
                        //System.out.println("Quartz 调度任务中已存在该任务");
                        if (status.equals("0")) {
                            JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
                            scheduler.deleteJob(jobKey);
                            continue;
                        }
                        //调度器中的表达式
                        String cronExpression =
                                cronTrigger.getCronExpression();

                        if (!cron.equals(cronExpression)) {
                            //创建表达式调度器
                            CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(cron);

                            //重构
                            cronTrigger = cronTrigger.getTriggerBuilder()
                                    .withIdentity(triggerKey)
                                    .withSchedule(cronSchedule)
                                    .build();

                            //刷新调度器
                            scheduler.rescheduleJob(triggerKey, cronTrigger);
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
