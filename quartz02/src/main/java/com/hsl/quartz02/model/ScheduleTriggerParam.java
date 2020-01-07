package com.hsl.quartz02.model;

public class ScheduleTriggerParam {
    private Integer param_id;

    private String name;

    private String value;

    private Integer schedule_trigger_id;

    public ScheduleTriggerParam(Integer param_id, String name, String value, Integer schedule_trigger_id) {
        this.param_id = param_id;
        this.name = name;
        this.value = value;
        this.schedule_trigger_id = schedule_trigger_id;
    }

    public ScheduleTriggerParam() {
        super();
    }

    public Integer getParam_id() {
        return param_id;
    }

    public void setParam_id(Integer param_id) {
        this.param_id = param_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSchedule_trigger_id() {
        return schedule_trigger_id;
    }

    public void setSchedule_trigger_id(Integer schedule_trigger_id) {
        this.schedule_trigger_id = schedule_trigger_id;
    }
}