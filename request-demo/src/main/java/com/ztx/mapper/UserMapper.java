package com.ztx.mapper;

import com.ztx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.jws.soap.SOAPBinding;

public interface UserMapper {
    //根据用户名和密码查询用户对象
    @Select("select * from tb_user where username=#{username} and password=#{password}")
    User select(@Param("username")String username,@Param("password") String password);

    //根据用户名查询用户对象
    @Select("select * from tb_user where username=#{username}")
    User selectByUsername(String username);

    @Insert("insert into tb_user values(null,#{username},#{password})")
    void add(User user);
}
