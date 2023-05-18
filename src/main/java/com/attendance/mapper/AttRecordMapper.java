package com.attendance.mapper;

import com.attendance.entity.domain.AttRecord;
import com.attendance.entity.dto.AttRecordDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zhouyihang
* @description 针对表【att_record】的数据库操作Mapper
* @createDate 2023-05-14 14:35:00
* @Entity com.attendance.entity.domain.AttRecord
*/
public interface AttRecordMapper extends BaseMapper<AttRecord> {

    List<AttRecordDto> statisticalRecordWithMouth(@Param("mouth") String mouth);

}




