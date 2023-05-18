package com.attendance.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

/**
 * 
 * @TableName att_record
 */
@TableName(value ="att_record")
@Data
public class AttRecord implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 员工id
     */
    private Integer staffId;


    /**
     * 0上午 1下午
     */
    private Integer type;

    /**
     * 状态，0正常，1迟到，2旷工
     */
    private Integer state;

    /**
     * 打卡日期
     */
    private LocalTime time;


    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}