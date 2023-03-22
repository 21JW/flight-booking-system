package com.example.mybatis_practice_user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_practice_user.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from demo_user2 where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from demo_user2 where email = #{email}")
    User findByEmail(@Param("email") String email);

    @Select("select * from demo_user2 where username = #{username}")
    User findByUserName(@Param("username") String username);

    List<User> findByIdList(List<Integer> idList);
}
