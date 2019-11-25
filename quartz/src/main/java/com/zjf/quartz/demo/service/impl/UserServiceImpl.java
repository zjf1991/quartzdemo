package com.zjf.quartz.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zjf.quartz.demo.entity.User;
import com.zjf.quartz.demo.mapper.UserMapper;
import com.zjf.quartz.demo.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
