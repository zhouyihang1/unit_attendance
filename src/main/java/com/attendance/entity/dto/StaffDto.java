package com.attendance.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author zhouyihang
 * @version 1.0
 * @description: TODO
 * @date 2023/5/14 18:29
 */
@Data
public class StaffDto {

    /**
     * 主键id
     */
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

    /**
     * 部门名称
     */
    private String departmentName;
}
