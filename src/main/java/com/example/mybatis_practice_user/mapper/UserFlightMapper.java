package com.example.mybatis_practice_user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_practice_user.model.vo.UserFlightResponse;
import com.example.mybatis_practice_user.model.entity.UserFlight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserFlightMapper extends BaseMapper<UserFlight> {
    @Select("select * from user_flight where user_id = #{userId} AND flight_id= #{flightId}")
    UserFlight findByUserIdANDFlightId(@Param("userId") Integer userId,@Param("flightId") Integer flightId);

    @Select("select uf.id, u.username, f.flight_name from user_flight uf,demo_user2 u,flight f WHERE uf.user_id=u.id AND uf.flight_id=f.id")
    List<UserFlightResponse> findUserFlightResponse();
}

