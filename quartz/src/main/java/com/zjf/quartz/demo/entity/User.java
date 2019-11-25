package com.zjf.quartz.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

public class User extends Model<User> {

    private static final long serialVersionUID = 1L;
    @Override
    protected Serializable pkVal() {
        return null;
    }

    private  Integer id;
    private  String name;
    private  Integer age;

    public User() {
    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
