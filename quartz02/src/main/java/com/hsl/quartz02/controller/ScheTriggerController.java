package com.hsl.quartz02.controller;

import com.hsl.quartz02.model.ScheduleTrigger;
import com.hsl.quartz02.service.ScheduleTriggerService;
import com.hsl.quartz02.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2020-01-05 19:12
 */
@Controller
@RequestMapping("/scheduleTrigger")
public class ScheTriggerController {
//    @Autowired
//    private Scheduler scheduler;
    @Autowired
    private ScheduleTriggerService scheduleTriggerService;
//    @Autowired
//    private ScheduleTriggerParamService triggerParamService;

    @ResponseBody
    @RequestMapping("/list")
    public ModelAndView list(ScheduleTrigger schTrigger, HttpServletRequest request) {
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<ScheduleTrigger> scheduleTriggers = scheduleTriggerService.queryScheduleTriggerPager(schTrigger,pageBean);
            modelAndView.addObject("scheduleTriggers", scheduleTriggers);
                modelAndView.addObject("pageBean", pageBean);
                modelAndView.setViewName("list");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }


    /**
     * 修改
     * @param schTrigger
     * @return
     */
    @RequestMapping("/toEdit")
    public ModelAndView toEdit(ScheduleTrigger schTrigger){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("edit");
        if(!(schTrigger.getId()==null||"".equals(schTrigger.getId()))){
            ScheduleTrigger t=scheduleTriggerService.selectByPrimaryKey(schTrigger.getId());
            modelAndView.addObject("scheduleTrigger",t);
        }
        return modelAndView;
    }

    /**
     * 添加
     * @param schTrigger
     * @return
     */
    @RequestMapping("/add")
    public String add(ScheduleTrigger schTrigger){
        try {
            scheduleTriggerService.insert(schTrigger);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/scheduleTrigger/list";
    }

    /**
     * 修改
     * @param schTrigger
     * @return
     */
    @RequestMapping("/edit")
    public String edit(ScheduleTrigger schTrigger){

        scheduleTriggerService.updateByPrimaryKey(schTrigger);

        return "redirect:/scheduleTrigger/list";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/del/{id}")
    public String del(@PathVariable(value = "id") Integer id){
        scheduleTriggerService.deleteByPrimaryKey(id);
        return "redirect:/scheduleTrigger/list";
    }

}
