package com.zjf.quartz.job.task;


import com.zjf.quartz.demo.entity.User;
import com.zjf.quartz.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 测试定时任务(演示Demo，可删除)
 * <p>
 * testTask为spring bean的名称
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月30日 下午1:34:24
 */
@Component("testTask")
public class TestTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService iUserService;

    // 定时任务只能接受一个参数；如果有多个参数，使用json数据即可
    public void test(String params) {
        logger.info("我是带参数的test方法，正在被执行，参数为：" + params);

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void test2() {
        logger.info("我是不带参数的test2方法，正在被执行");
    }

    public void test3() {// 测试

        logger.info("我是不带参数的test2方法，正在被执行");
    }


    public void test4(String name) {// 测试

        User user = iUserService.selectById(1);
        System.out.println(user.toString());
        user.setName(name);
        iUserService.updateById(user);

        logger.info(name+"的程序正在被执行");
    }
}
