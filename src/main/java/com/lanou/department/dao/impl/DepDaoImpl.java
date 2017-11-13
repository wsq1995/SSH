package com.lanou.department.dao.impl;

import com.lanou.department.dao.DepDao;
import com.lanou.staff.domain.Department;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */

public class DepDaoImpl extends HibernateDaoSupport implements DepDao {
    //    添加部门
    @Override
    public List<Department> save(Department department) {
        String depID = department.getDepID();

        if (depID == null || depID.isEmpty()) {
            getHibernateTemplate().save(department);
        } else {
            getHibernateTemplate().saveOrUpdate(department);
        }
        return null;
    }

    //    查询所有部门
    @Override
    public List<Department> listDep() {
        String sql = "from Department crm_department";
        List<Department> list = (List<Department>) getHibernateTemplate().find(sql);
        return list;
    }

    //    编辑部门
    @Override
    public void editDep(Department department) {
        getHibernateTemplate().saveOrUpdate(department);
    }


}
