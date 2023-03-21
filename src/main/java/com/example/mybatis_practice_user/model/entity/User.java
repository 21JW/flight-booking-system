package com.example.mybatis_practice_user.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mybatis_practice_user.enumeration.UserStatus;
import com.example.mybatis_practice_user.model.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;


@Data
@TableName(value = "demo_user2")
public class User {
    @TableId(type = IdType.AUTO)
    Integer id;

    String username;

    String password;

    String email;

    @Enumerated(EnumType.STRING)
    UserStatus status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="America/Toronto")
    Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="America/Toronto")
    Date ts;


    public User(UserDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
