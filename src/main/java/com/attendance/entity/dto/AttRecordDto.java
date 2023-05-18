package com.attendance.entity.dto;

import lombok.Data;

/**
 * @author zhouyihang
 * @version 1.0
 * @description: TODO
 * @date 2023/5/18 16:03
 */
@Data
public class AttRecordDto {
    private Integer id;

    private String username;

    private Integer absences;

    private Integer absenteeism;
}
