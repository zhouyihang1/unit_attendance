package com.attendance.controller;

import com.attendance.entity.domain.Department;
import com.attendance.entity.domain.Staff;
import com.attendance.entity.dto.StaffDto;
import com.attendance.service.DepartmentService;
import com.attendance.service.StaffService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zhouyihang
 * @version 1.0
 * @description: TODO
 * @date 2023/5/14 18:15
 */
@RequestMapping("/staff")
@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/list")
    public ModelAndView list(ModelAndView modelAndView, @RequestParam(value = "username",required = false) String username){
        List<StaffDto> list = staffService.selectAllStaff(username);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("staff_list");
        return modelAndView;
    }


    @ResponseBody
    @PostMapping("/add")
    public int add(Staff staff){
        boolean save = staffService.save(staff);
        return save ? 1 : 0;
    }

    @ResponseBody
    @PostMapping("/edit")
    public int update(Staff staff){
        boolean update = staffService.updateById(staff);
        return update ? 1 : 0;
    }

    @ResponseBody
    @GetMapping("/delete")
    public int delete(Integer id){
        boolean remove = staffService.removeById(id);
        return remove ? 1 : 0;
    }

    @GetMapping("/info")
    public ModelAndView info(HttpSession session,ModelAndView modelAndView){
        Staff staff = (Staff) session.getAttribute("user");
        staff = staffService.getById(staff.getId());
        Department department = departmentService.getOne(new LambdaQueryWrapper<Department>().eq(Department::getId, staff.getDepId()));
        StaffDto staffDto = new StaffDto();
        BeanUtils.copyProperties(staff,staffDto);
        staffDto.setDepartmentName(department.getDepName());
        modelAndView.addObject("staff",staffDto);
        modelAndView.setViewName("staff_info");
        return modelAndView;
    }

}
