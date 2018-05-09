package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.domain.Employee;
import com.ssm.domain.Msg;
import com.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmploymeeController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithIson(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,10);
        List<Employee> list = employeeService.getAll();
        //使用pageInfo包装分页 连续显示页数5页
        PageInfo page =new PageInfo(list,5);
        return Msg.success().add("pageInfo",page);
    }
//    @RequestMapping("/emps")
//    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
//        //分页查询 引入pageHelper
//        PageHelper.startPage(pn,10);
//        List<Employee> list = employeeService.getAll();
//        //使用pageInfo包装分页 连续显示页数5页
//        PageInfo page =new PageInfo(list,5);
//        model.addAttribute("pageInfo",page);
//
//        return "list";
//    }
}
