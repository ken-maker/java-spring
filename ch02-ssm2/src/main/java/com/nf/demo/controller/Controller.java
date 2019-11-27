package com.nf.demo.controller;

import com.github.pagehelper.PageInfo;
import com.nf.demo.entity.Employee;
import com.nf.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired(required = true)
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue = "2")int pageSize,
                             ModelAndView mav){
        List<Employee> all = employeeService.getAll(pageNum, pageSize);
        PageInfo employeePageInfo = new PageInfo(all);
        mav.addObject("employees",employeePageInfo);
        mav.setViewName("list");
        return mav;
    }
}
