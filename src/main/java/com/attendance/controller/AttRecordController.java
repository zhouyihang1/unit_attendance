package com.attendance.controller;

import com.attendance.entity.domain.AttRecord;
import com.attendance.entity.domain.Staff;
import com.attendance.entity.dto.AttRecordDto;
import com.attendance.service.AttRecordService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.xml.ws.BindingType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @author zhouyihang
 * @version 1.0
 * @description: TODO
 * @date 2023/5/18 14:55
 */
@RequestMapping("/att")
@Controller
public class AttRecordController {

    @Autowired
    private AttRecordService attRecordService;


    @GetMapping("/add")
    @ResponseBody
    public String addPunchTheClock(HttpSession session){
        Staff staff = (Staff)session.getAttribute("user");
        int hour = LocalDateTime.now().getHour();
        int type = hour < 12 ? 0 : 1;
        AttRecord record = attRecordService.getOne(new LambdaQueryWrapper<AttRecord>().eq(AttRecord::getStaffId, staff.getId()).eq(AttRecord::getType, type));
        if(record != null){
            return "已打卡！";
        }
        record = new AttRecord();
        record.setStaffId(staff.getId());
        record.setType(type);
        record.setTime(LocalTime.now());
        record.setCreatedAt(LocalDateTime.now());
        attRecordService.save(record);
        return "打卡成功！";
    }

    @GetMapping("/statistical")
    public ModelAndView record(String month, ModelAndView modelAndView){
        if (month == null) {
            month = String.valueOf(LocalDateTime.now().getMonthValue());
        }
        List<AttRecordDto> attRecordDtos =
                attRecordService.statisticalRecordWithMouth(month);
        modelAndView.addObject("attRecordDtos",attRecordDtos);
        modelAndView.setViewName("attrecord_statistical_list");
        return modelAndView;
    }

}
