package com.lanou.page.service.impl;

import com.lanou.page.domain.PageBean;
import com.lanou.page.service.PageService;
import com.lanou.staff.domain.Department;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by dllo on 17/11/17.
 */
public class PageServiceImpl implements PageService {
    /**
     * 条件查询
     * @param department
     * @param pageNum    当前页
     * @param pageSize   每页显示的条目数
     * @return
     */
    @Override
    public PageBean<Department> findAll(Department department, int pageNum, int pageSize) {
//        拼凑查询条件
        StringBuilder sb = new StringBuilder();
//        拼凑参数,参数可重复
        List<Object> paramsList = new ArrayList<Object>();
//        过滤条件:借助lang3中的工具类
        if (StringUtils.isNotBlank(department.getDepID())){
            sb.append("and depName like?");
            paramsList.add("%"+department.getDepName()+"%");
        }
        return null;
    }
}
