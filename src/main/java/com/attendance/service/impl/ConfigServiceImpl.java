package com.attendance.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.attendance.entity.domain.Config;
import com.attendance.service.ConfigService;
import com.attendance.mapper.ConfigMapper;
import org.springframework.stereotype.Service;

/**
* @author zhouyihang
* @description 针对表【config】的数据库操作Service实现
* @createDate 2023-05-14 14:35:00
*/
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config>
    implements ConfigService{

}




