package com.lanou.staff.dao.impl;

import com.lanou.staff.dao.StaffDao;
import com.lanou.staff.domain.Staff;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Repository("staffDao")
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {


    @Override
    public void login(Staff staff) {
        getHibernateTemplate().save(staff);

    }

    @Override
    public List<Staff> query(Staff staff) {
        return null;
    }

    @Override
    public List<Staff> update(Staff staff) {
        return null;
    }
}
