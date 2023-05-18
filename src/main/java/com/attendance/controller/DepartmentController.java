package com.attendance.controller;

import com.attendance.entity.domain.Department;
import com.attendance.service.DepartmentService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zhouyihang
 * @version 1.0
 * @description: TODO
 * @date 2023/5/14 15:27
 */
@Controller
@RequestMapping("/depart")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list")
    public ModelAndView list(ModelAndView modelAndView,@RequestParam(value = "depName",required = false) String depName){
        List<Department> list = departmentService.list(new LambdaQueryWrapper<Department>().like(StringUtils.isNotBlank(depName),Department::getDepName,depName));
        modelAndView.addObject("list",list);
        modelAndView.setViewName("depart_list");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping("/all")
    public List<Department> all(){
        return departmentService.list();
    }


    @ResponseBody
    @PostMapping("/add")
    public int add(Department department){
        boolean save = departmentService.save(department);
        return save ? 1 : 0;
    }

    @ResponseBody
    @PostMapping("/edit")
    public int update(Department department){
        boolean update = departmentService.updateById(department);
        return update ? 1 : 0;
    }

    @ResponseBody
    @GetMapping("/delete")
    public int delete(Integer id){
        boolean remove = departmentService.removeById(id);
        return remove ? 1 : 0;
    }

}
