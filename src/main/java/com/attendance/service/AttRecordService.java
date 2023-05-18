package com.attendance.service;

import com.attendance.entity.domain.AttRecord;
import com.attendance.entity.dto.AttRecordDto;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zhouyihang
* @description 针对表【att_record】的数据库操作Service
* @createDate 2023-05-14 14:35:00
*/
public interface AttRecordService extends IService<AttRecord> {

    List<AttRecordDto> statisticalRecordWithMouth( String mouth);

}
