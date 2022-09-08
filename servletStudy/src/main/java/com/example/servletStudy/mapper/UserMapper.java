package com.example.servletStudy.mapper;

import com.example.servletStudy.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> queryUser(String username);
}
