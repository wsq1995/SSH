package com.lanou.staff.dao.impl;
import com.lanou.staff.dao.StaffDao;
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
    public List<Staff> query(Staff staff) {
        String sql = "from Staff crm_staff";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql);
        return list;
    }

    //    更新员工
    @Override
    public List<Staff> update(Staff staff) {
        return null;
    }

    //    添加员工
    @Override
    public List<Staff> add(Staff staff) {
        getHibernateTemplate().save(staff);
        return null;
    }

    //    删除员工
    @Override
    public List<Staff> delete(Staff staff) {
        return null;
    }





}
