package com.attendance.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalTime;
import lombok.Data;

/**
 * 
 * @TableName config
 */
@TableName(value ="config")
@Data
public class Config implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 上班时间
     */
    private LocalTime startWorkTime;

    /**
     * 下班时间
     */
    private LocalTime endWorkTime;

    /**
     * 类型，0上午，1下午
     */
    private Integer type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}