package com.nf.demo.service.impl;

import com.nf.demo.dao.DeptDao;
import com.nf.demo.dao.EmployeeDao;
import com.nf.demo.entity.DeptEntity;
import com.nf.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

  @Autowired
  private DeptDao deptDao;
  @Autowired
  private EmployeeDao employeeDao;

  @Override
  public List<DeptEntity> getAll(int pageNum, int pageSize) {
        return deptDao.getAll(pageNum,pageSize);
  }

  @Override
  public void insert(String name) {
    deptDao.insert(name);
  }


@Transactional
  @Override
  public void deleteById(int deptId) {
    employeeDao.deleteByDeptId(deptId);
    deptDao.deleteById(deptId);
  }
}
