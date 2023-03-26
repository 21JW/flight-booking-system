package com.example.mybatis_practice_user.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mybatis_practice_user.model.dto.UserDTO;
import com.example.mybatis_practice_user.model.dto.UserFlightDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import java.util.Date;

@Data
@TableName(value = "user_flight")
@NoArgsConstructor
public class UserFlight {
    @TableId(type = IdType.AUTO)
    Integer id;

    Integer userId;

    Integer flightId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="America/Toronto")
    Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="America/Toronto")
    Date ts;

    public UserFlight(UserFlightDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }

}
