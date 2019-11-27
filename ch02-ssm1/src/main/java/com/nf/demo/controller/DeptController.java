package com.nf.demo.controller;

import com.github.pagehelper.PageInfo;
import com.nf.demo.entity.DeptEntity;
import com.nf.demo.service.DeptService;
import com.nf.demo.service.EmployeeService;
import com.nf.demo.service.impl.DeptServiceImpl;
import com.nf.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value="pageNum",required = false,defaultValue = "1") int pageNum,
                     @RequestParam(value="pageSize",required = false,defaultValue = "2")int pageSize,
                     ModelAndView modelAndView){
        List<DeptEntity> all = deptService.getAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(all);
        modelAndView.addObject("DeptAll",pageInfo);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @GetMapping("/add")
    public String add(){
        return "add";
    }

    @PostMapping("/insert")
    public String insert(@Valid DeptEntity deptEntity, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "add";
        }
        deptService.insert(deptEntity.getName());
        return "redirect:list";
    }

    @GetMapping("/delete")
    public String delete(int deptId){
       deptService.deleteById(deptId);
        return "redirect:list";
    }

}
