package com.example.servletStudy.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionUtil {


    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        try{
            String resource = "mybatis-config.xml";
            //FileReader fileReader=new FileReader(resource);
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession=sqlSessionFactory.openSession(true);
        }catch (Exception e){
            System.out.println("get sqlSession error-->{}"+e);
        }
        return sqlSession;

    }
}
