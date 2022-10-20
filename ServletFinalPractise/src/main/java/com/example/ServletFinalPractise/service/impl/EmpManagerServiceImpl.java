package com.example.ServletFinalPractise.service.impl;

import com.example.ServletFinalPractise.Utils.SqlSessionUtil;
import com.example.ServletFinalPractise.entity.EmpManager;
import com.example.ServletFinalPractise.mapper.EmpManagerMapper;
import com.example.ServletFinalPractise.service.EmpManagerService;
import org.apache.ibatis.session.SqlSession;

public class EmpManagerServiceImpl implements EmpManagerService {

    @Override
    public EmpManager login(String username, String pwd) {
        EmpManager manager=null;
        try(SqlSession session= SqlSessionUtil.getSqlSession()){
            EmpManagerMapper mapper=session.getMapper(EmpManagerMapper.class);
            EmpManager manager1=mapper.selectEmpManager(username);
            if (null!=manager1){
                if (manager1.getPASSWORD().equals(pwd)){
                    manager=manager1;
                }
            }
        }catch (Exception e){
            System.out.println("报错啦"+e.getMessage());
        }
        return manager;
    }
}
