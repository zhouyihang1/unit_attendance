package com.attendance.controller;

import com.attendance.entity.domain.Config;
import com.attendance.entity.vo.ConfigVo;
import com.attendance.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;
import java.util.List;

/**
 * @author zhouyihang
 * @version 1.0
 * @description: TODO
 * @date 2023/5/14 20:17
 */
@RequestMapping("/config")
@Controller
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @GetMapping("/list")
    public ModelAndView list(ModelAndView modelAndView){
        List<Config> list = configService.list();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("config_list");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping("edit")
    public int update(ConfigVo configVo){
        Config config = new Config();
        config.setId(configVo.getId());
        LocalTime startTime = LocalTime.parse(configVo.getStartWorkTime());
        LocalTime endTime = LocalTime.parse(configVo.getEndWorkTime());
        config.setStartWorkTime(startTime);
        config.setEndWorkTime(endTime);
        boolean b = configService.updateById(config);
        return b ? 1 : 0;
    }


}
