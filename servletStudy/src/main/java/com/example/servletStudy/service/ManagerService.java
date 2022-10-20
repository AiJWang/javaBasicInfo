package com.example.servletStudy.service;

import com.example.servletStudy.entity.Manager;

public interface ManagerService {
    Manager login(String username,String pwd);
}
