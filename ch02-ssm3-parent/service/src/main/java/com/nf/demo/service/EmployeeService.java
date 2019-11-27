package com.nf.demo.service;

import com.nf.demo.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll(@Param("pageNum") int pageNum,
                          @Param("pageSize") int pageSize);

//    void insert(BigDecimal salary, Date hiredate, Integer gender, String username, Integer deptid);

    void insert(Employee employee);
}
