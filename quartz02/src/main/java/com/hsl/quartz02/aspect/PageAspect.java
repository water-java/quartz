package com.hsl.quartz02.aspect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hsl.quartz02.util.PageBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author water
 * @site www.water.com
 * @company xxx公司
 * @create 2019-11-17 18:55
 */
@Component
@Aspect
public class PageAspect {
    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        PageBean pageBean=null;
        for (Object arg : args) {
            if(arg instanceof PageBean){
                pageBean=(PageBean)arg;
                break;
            }

        }
        if(pageBean!=null&& pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }

        Object proceed = joinPoint.proceed(args);
        if(null!=pageBean && pageBean.isPagination()){
            PageInfo pageInfo=new PageInfo((List) proceed);
            System.out.println("-------------------"+pageInfo.getTotal());
            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        return proceed;
    }
}
