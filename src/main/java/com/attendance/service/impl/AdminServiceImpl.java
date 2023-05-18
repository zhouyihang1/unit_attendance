package com.attendance.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.attendance.entity.domain.Admin;
import com.attendance.service.AdminService;
import com.attendance.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
* @author zhouyihang
* @description 针对表【admin】的数据库操作Service实现
* @createDate 2023-05-14 14:35:00
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




