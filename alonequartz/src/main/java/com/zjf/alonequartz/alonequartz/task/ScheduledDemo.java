package com.zjf.alonequartz.alonequartz.task;

import com.zjf.alonequartz.demo.entity.User;
import com.zjf.alonequartz.demo.service.IUserService;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
public class ScheduledDemo {


    @Resource
    private IUserService iUserService;


    @Scheduled(cron = "0 36 14 * * ?")
    public void executeInternal() throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        User user = iUserService.selectById(1);
        System.out.println(user.toString());
        user.setName("办法还是不");
        iUserService.updateById(user);
        System.out.println("Scheduled----" + sdf.format(new Date()));

    }
}
