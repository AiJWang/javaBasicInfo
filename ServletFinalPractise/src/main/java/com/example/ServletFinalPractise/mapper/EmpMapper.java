package com.example.ServletFinalPractise.mapper;

import com.example.ServletFinalPractise.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    List<Emp> getAllEmp();

    void deleteEmpById(@Param("id")int id);

    void update(Emp emp);

    Emp getEmpById(@Param("id")int id);
}
