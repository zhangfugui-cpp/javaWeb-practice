package com.ztx.test;

import com.ztx.mapper.BrandMapper;
import com.ztx.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTset {
    @Test
    public void selectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();

        for(Brand brand:brands)
        System.out.println(brand);

        sqlSession.close();

    }

    @Test
    public void testSelectById() throws IOException {
        int id=1;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectByIdBrand(id);
        System.out.println(brand);

        sqlSession.close();

    }

    @Test
    public void add() throws IOException {
        String brandName="苹果手机16pro";
        String companyName="苹果";
        int ordered=100;
        String description="牛比";
        int status=1;

        Brand brand = new Brand();

        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setCompanyName(companyName);
        brand.setStatus(status);
        brand.setOrdered(ordered);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);

        sqlSession.commit();

        sqlSession.close();

    }
}
