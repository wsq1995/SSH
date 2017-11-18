package com.lanou.department.service;

import com.lanou.staff.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface DepService {
    //    保存部门
    List<Department> save(Department department);

    //    查询部门
    List<Department> listDep();

    //    编辑部门
    void editDep(Department department);


    //    通过id查找部门
    List<Department> findDepID(String depID);
}
