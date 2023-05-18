package com.attendance.service;

import com.attendance.entity.domain.Staff;
import com.attendance.entity.dto.StaffDto;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author zhouyihang
* @description 针对表【staff】的数据库操作Service
* @createDate 2023-05-14 14:35:00
*/
public interface StaffService extends IService<Staff> {


    /**
     * 员工列表
     *
     * @return {@link List}<{@link StaffDto}>
     */
    List<StaffDto> selectAllStaff(String username);

}
