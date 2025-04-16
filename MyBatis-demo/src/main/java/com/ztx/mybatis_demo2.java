package com.ztx;

import com.ztx.mapper.UserMapper;
import com.ztx.pojo.emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
//mybatis使用mapper代理开发

public class mybatis_demo2 {
    public static void main(String[] args) throws IOException {
        //加载mybatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象，执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.执行语句
        //List<emp> empList = sqlSession.selectList("test.selectAll");

        //3.1获取usermapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<emp> emps = userMapper.selectAll();

        for(emp e:emps){
            System.out.println(e);
        }
        sqlSession.close();
    }
}
