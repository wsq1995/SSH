package com.lanou.department.service.impl;

import com.lanou.department.dao.DepDao;
import com.lanou.department.service.DepService;
import com.lanou.staff.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */

public class DepServiceImpl implements DepService {

    private DepDao depDao;

    //    添加部门
    @Override
    public List<Department> save(Department department) {
        return depDao.save(department);
    }

//    查询所有部门
    @Override
    public List<Department> listDep() {
        return depDao.listDep();
    }

//    编辑部门
    @Override
    public void editDep(Department department) {
        depDao.editDep(department);
    }

//    通过id查找部门
    @Override
    public List<Department> findDepID(String depID) {
        return depDao.findDepID(depID);
    }

    public void setDepDao(DepDao depDao) {
        this.depDao = depDao;
    }
}
