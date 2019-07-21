package com.leo.spring.jpa.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户
 */
@Entity
@Data
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue
    private Long id; //ID

    private String name; //姓名

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime; //创建时间

    private String memo; //备注
}
