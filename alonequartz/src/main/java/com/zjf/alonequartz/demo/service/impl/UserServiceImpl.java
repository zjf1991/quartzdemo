package com.zjf.alonequartz.demo.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zjf.alonequartz.demo.entity.User;
import com.zjf.alonequartz.demo.mapper.UserMapper;
import com.zjf.alonequartz.demo.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
