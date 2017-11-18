package com.lanou.page.dao;

import com.lanou.staff.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/17.
 */
public interface PageDao {
//    获取总的记录数
//    1.condition,带条件的
//    2.params:参数
    int getTotalRecord(String condition,Object[]params);

    List<Department> findAll(String condition,Object[]params,int startIndex,int pageSize);

}
