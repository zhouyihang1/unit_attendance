package com.attendance.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalTime;

/**
 * @author zhouyihang
 * @version 1.0
 * @description: TODO
 * @date 2023/5/14 20:41
 */
@Data
public class ConfigVo {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 上班时间
     */
    private String startWorkTime;

    /**
     * 下班时间
     */
    private String endWorkTime;

    /**
     * 类型，0上午，1下午
     */
    private String type;
}
