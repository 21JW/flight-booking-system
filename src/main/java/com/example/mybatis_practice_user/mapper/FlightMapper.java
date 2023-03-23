package com.example.mybatis_practice_user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_practice_user.model.entity.Flight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface FlightMapper extends BaseMapper<Flight> {
    @Select("select * from flight where flight_name = #{flightName} AND depart_time= #{departTime}")
    Flight findByFlightNameANDDepartTime(@Param("flightName") String flightName,@Param("departTime") Date departTime);

    @Select("select * from flight where id = #{id}")
    Flight findFlightById(@Param("id")Integer id);
}
