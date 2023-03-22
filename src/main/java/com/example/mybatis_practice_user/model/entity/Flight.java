package com.example.mybatis_practice_user.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mybatis_practice_user.model.dto.FlightDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import java.util.Date;

@Data
@TableName(value = "flight")
@NoArgsConstructor
public class Flight {
    @TableId(type = IdType.AUTO)
    Integer id;

    private String company;

    private String flightName;

    private String departure;

    private String destination;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Toronto")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Toronto")
    private Date ts;

    private Integer price;

    private Date departTime;

    public Flight(FlightDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
