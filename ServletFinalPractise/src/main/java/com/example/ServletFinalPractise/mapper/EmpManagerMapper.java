package com.example.ServletFinalPractise.mapper;

import com.example.ServletFinalPractise.entity.EmpManager;
import org.apache.ibatis.annotations.Param;

public interface EmpManagerMapper {

    EmpManager selectEmpManager(@Param("username") String username);

}
