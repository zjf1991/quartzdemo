package com.zjf.quartz.demo.controller;

import com.zjf.quartz.common.R;
import com.zjf.quartz.demo.entity.User;
import com.zjf.quartz.demo.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private IUserService iUserService;

    @RequestMapping("/user/add")
    public R addUser() {

        User user = new User();
        user.setName("展示");
        user.setAge(23);
        user.insert();
        return R.ok();
    }

    @RequestMapping("/user/update")
    public R update() {

        User user = iUserService.selectById(1);
        user.setName("张三");
        iUserService.updateById(user);
        return R.ok();
    }
}
