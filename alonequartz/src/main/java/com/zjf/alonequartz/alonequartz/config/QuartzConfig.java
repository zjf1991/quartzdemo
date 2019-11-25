package com.zjf.alonequartz.alonequartz.config;


import com.zjf.alonequartz.alonequartz.task.TestTask2;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时配置
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail testQuartz1() {
        return JobBuilder.newJob(TestTask2.class).withIdentity("testTask1").storeDurably().build();
    }

//    @Bean
//    public Trigger testQuartzTrigger1() {
//        //5秒执行一次 任务调度器
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(5)
//                .repeatForever();
//        return TriggerBuilder.newTrigger().forJob(testQuartz1())
//                .withIdentity("testTask1")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }

    @Bean
    public JobDetail testQuartz2() {
        return JobBuilder.newJob(TestTask2.class).withIdentity("testTask2").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger2() {

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 41 14 * * ?");
        //cron方式，每隔5秒执行一次
        return TriggerBuilder.newTrigger().forJob(testQuartz2())
                .withIdentity("testTask2")
                .withSchedule(cronScheduleBuilder)
                .build();
    }


}
