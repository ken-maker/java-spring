package com.nf.demo.controller;

import com.github.pagehelper.PageInfo;
import com.nf.demo.entity.Employee;
import com.nf.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @InitBinder
    public void test(WebDataBinder webDataBinder){
        DateFormatter dateFormatter = new DateFormatter();
       // dateFormatter.setPattern("yyyy-MM-dd");
        webDataBinder.addCustomFormatter(dateFormatter);
    }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize",required = false,defaultValue = "2") int pageSize,
                             ModelAndView mav){
        List<Employee> all = employeeService.getAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(all);
        mav.addObject("employees",pageInfo);
        mav.setViewName("list");
        return mav;
    }


    @GetMapping("/add")
    public String  add(){
        return "add";
    }

    @PostMapping("/insert")
    public String insert(@Valid Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println("bindingResult.getFieldError() = " + bindingResult.getFieldError());
            return "redirect:add";
        }
        employeeService.insert(employee);
        return "redirect:list";
    }

}
