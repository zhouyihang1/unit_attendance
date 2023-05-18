package com.attendance.service.impl;

import com.attendance.entity.dto.AttRecordDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.attendance.entity.domain.AttRecord;
import com.attendance.service.AttRecordService;
import com.attendance.mapper.AttRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author zhouyihang
* @description 针对表【att_record】的数据库操作Service实现
* @createDate 2023-05-14 14:35:00
*/
@Service
public class AttRecordServiceImpl extends ServiceImpl<AttRecordMapper, AttRecord>
    implements AttRecordService{

    @Autowired
    private AttRecordMapper attRecordMapper;

    @Override
    public List<AttRecordDto> statisticalRecordWithMouth(String mouth) {
        return attRecordMapper.statisticalRecordWithMouth(mouth);
    }
}




