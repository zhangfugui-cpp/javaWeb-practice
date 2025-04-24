package com.ztx.web;

import com.ztx.mapper.UserMapper;
import com.ztx.pojo.User;
import com.ztx.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //接受用户数据
        String username = req.getParameter("username");
        String password=req.getParameter("password");

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User u=userMapper.selectByUsername(username);


        //判断是否存在
        if(u==null){
            userMapper.add(user);
            sqlSession.commit();//提交事务
            sqlSession.close();
        }else{
            resp.setContentType("test/html;charset=utf-8");
            resp.getWriter().write("用户名已存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
