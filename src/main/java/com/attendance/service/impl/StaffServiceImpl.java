package com.attendance.service.impl;

import com.attendance.entity.dto.StaffDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.attendance.entity.domain.Staff;
import com.attendance.service.StaffService;
import com.attendance.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author zhouyihang
* @description 针对表【staff】的数据库操作Service实现
* @createDate 2023-05-14 14:35:00
*/
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff>
    implements StaffService{

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<StaffDto> selectAllStaff(String username) {
        return staffMapper.selectAllStaffWithDepName(username);
    }
}




