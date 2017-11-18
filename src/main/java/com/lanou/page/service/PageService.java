package com.lanou.page.service;

import com.lanou.page.domain.PageBean;
import com.lanou.staff.domain.Department;

/**
 * Created by dllo on 17/11/17.
 */
public interface PageService {
//    查询所有,分页查询

    /**
     *
     * @param department
     * @param pageNum    当前页
     * @param pageSize   每页显示的条目数
     * @return
     */

    PageBean<Department>findAll(Department department,int pageNum,int pageSize);
}
