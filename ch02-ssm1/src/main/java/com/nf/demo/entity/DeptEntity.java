package com.nf.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

public class DeptEntity {

    private Integer id;


    @NotEmpty
    @Size(min=3,max = 10,message = "字符长度在 3-10 之间")
    private String name;

//    @Digits(integer = 1000,fraction = 00)  必须是整数，在指定范围之内
//    @Min(0) 下限
//    @FutureOrPresent  将来或现在的日期
//    @DateTimeFormat  类型转换

    @Override
    public String toString() {
        return "DeptEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
