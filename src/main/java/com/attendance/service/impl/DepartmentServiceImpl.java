package com.attendance.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.attendance.entity.domain.Department;
import com.attendance.service.DepartmentService;
import com.attendance.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

/**
* @author zhouyihang
* @description 针对表【department】的数据库操作Service实现
* @createDate 2023-05-14 14:35:00
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService{

}




