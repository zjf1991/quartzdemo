package com.zjf.alonequartz.demo.controller;


import com.zjf.alonequartz.common.DataSources.DataSourceNames;
import com.zjf.alonequartz.common.DataSources.annotation.CurDataSource;
import com.zjf.alonequartz.common.R;
import com.zjf.alonequartz.demo.entity.User;
import com.zjf.alonequartz.demo.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private IUserService iUserService;

    @CurDataSource(name = DataSourceNames.FIRST)
    @RequestMapping("/user/first/add")
    public R addUser() {

        User user = new User();
        user.setName("展示");
        user.setAge(23);
        user.insert();
        return R.ok();
    }

    @CurDataSource(name = DataSourceNames.FIRST)
    @RequestMapping("/user/first/update")
    public R update() {

        User user = iUserService.selectById(1);
        user.setName("张三");
        iUserService.updateById(user);
        return R.ok();
    }

    @CurDataSource(name = DataSourceNames.SECOND)
    @RequestMapping("/user/second/add")
    public R secondAddUser() {

        User user = new User();
        user.setName("展示");
        user.setAge(23);
        user.insert();
        return R.ok();
    }

    @CurDataSource(name = DataSourceNames.SECOND)
    @RequestMapping("/user/second/update")
    public R secondupdate() {

        User user = iUserService.selectById(1);
        user.setName("张三");
        iUserService.updateById(user);
        return R.ok();
    }
}
