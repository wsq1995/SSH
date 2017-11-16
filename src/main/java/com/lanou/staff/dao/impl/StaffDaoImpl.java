package com.lanou.staff.dao.impl;

import com.lanou.staff.dao.StaffDao;
import com.lanou.staff.domain.Post;
import com.lanou.staff.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Repository("staffDao")
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {
    @Override
    public List<Staff> login(Staff staff) {
        String sql = "from Staff crm_staff where loginName=? and loginPwd=?";
        Object[] value = {staff.getLoginName(), staff.getLoginPwd()};
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, value);
        return list;
    }

    //    查询员工
    @Override
    public List<Staff> query() {
        String sql = "from Staff crm_staff";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
        return list;
    }


    //   根据部门id查询职务
    @Override
    public List<Post> findPostByDepID(String depID) {
        String sql = "from Post crm_post where dep.depID=?";
        List<Post> posts = (List<Post>) getHibernateTemplate().find(sql, depID);
        return posts;
    }

    //    添加员工
    @Override
    public List<Staff> saveStaff(Staff staff) {
        String staffId = staff.getStaffId();
        if (staffId == null || staffId.isEmpty()) {
            getHibernateTemplate().save(staff);
        }else {
            getHibernateTemplate().saveOrUpdate(staff);
        }
        return null;
    }

    //    编辑员工
    @Override
    public List<Staff> saveOrUpdata(Staff staff) {
        getHibernateTemplate().saveOrUpdate(staff);
        return null;
    }


}
