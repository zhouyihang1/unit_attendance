package com.attendance.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName staff
 */
@TableName(value ="staff")
@Data
public class Staff implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 员工姓名
     */
    private String username;

    /**
     * 员工密码
     */
    private String password;

    /**
     * 部门id
     */
    private Integer depId;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 电话
     */
    private String tel;

    /**
     * 住址
     */
    private String address;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}