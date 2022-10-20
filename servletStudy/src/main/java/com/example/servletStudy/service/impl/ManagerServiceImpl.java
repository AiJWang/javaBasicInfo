package com.example.servletStudy.service.impl;

import com.example.servletStudy.Utils.SqlSessionUtil;
import com.example.servletStudy.entity.Manager;
import com.example.servletStudy.mapper.ManagerMapper;
import com.example.servletStudy.service.ManagerService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ManagerServiceImpl implements ManagerService {

    @Override
    public Manager login(String username, String pwd) {
        Manager m=null;
        try( SqlSession sqlSession= SqlSessionUtil.getSqlSession()){
            ManagerMapper managerMapper=sqlSession.getMapper(ManagerMapper.class);
            m= managerMapper.getManager(username);
        }catch (Exception e){
            System.out.println("yichang-->{}");
        }
        return m;
    }
}
