package com.attendance.entity.vo;

import lombok.Data;

/**
 * @author zhouyihang
 * @version 1.0
 * @description: TODO
 * @date 2023/5/14 14:57
 */
@Data
public class LoginVo {
    private String username;
    private String password;
    private Integer identity;
}
