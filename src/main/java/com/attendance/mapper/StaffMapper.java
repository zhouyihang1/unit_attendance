package com.attendance.mapper;

import com.attendance.entity.domain.Staff;
import com.attendance.entity.dto.StaffDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zhouyihang
* @description 针对表【staff】的数据库操作Mapper
* @createDate 2023-05-14 14:35:00
* @Entity com.attendance.entity.domain.Staff
*/
public interface StaffMapper extends BaseMapper<Staff> {

    /**
     * 员工列表带上部门名称
     *
     * @return {@link List}<{@link StaffDto}>
     */
    List<StaffDto> selectAllStaffWithDepName(@Param("username") String username);

}




