package com.nf.demo.service;

import com.nf.demo.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll(@Param("pageNum") int pageNum,
                          @Param("pageSize") int pageSize);

}
