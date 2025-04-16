package com.ztx;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.ztx.pojo.emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class mybatis_demo {
    public static void main(String[] args) throws IOException {
        //加载mybatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象，执行sql
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //3.执行语句
        List<emp> empList = sqlSession.selectList("test.selectAll");

        for (emp e : empList) {
            System.out.println(e);
        }

        sqlSession.close();
    }
}
