package com.zjf.quartz.alonequartz.task;

import com.zjf.quartz.demo.entity.User;
import com.zjf.quartz.demo.service.IUserService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 当时任务2
 */
public class TestTask2 extends QuartzJobBean {

    @Resource
    private IUserService iUserService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        User user = iUserService.selectById(1);
        System.out.println(user.toString());
        user.setName("结婚酒");
        iUserService.updateById(user);
        System.out.println("TestQuartz02----" + sdf.format(new Date()));

    }
}
