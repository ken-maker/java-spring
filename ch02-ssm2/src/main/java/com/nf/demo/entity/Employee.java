package com.nf.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {

    private Integer id;
    private BigDecimal salary;
    private Date hiredate;
    private Integer gender;
    private String username;
    private Integer deptid;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", hiredate=" + hiredate +
                ", gender=" + gender +
                ", username='" + username + '\'' +
                ", deptid=" + deptid +
                '}';
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }
}
