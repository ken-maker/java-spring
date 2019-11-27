package com.nf.demo.service;

import com.nf.demo.entity.DeptEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptService {

    List<DeptEntity> getAll(@Param("pageNum") int pageNum,
                            @Param("pageSize") int pageSize);
    void insert(String name);
    void deleteById(int id);
}
