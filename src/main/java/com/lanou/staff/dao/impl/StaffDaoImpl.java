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

    private Staff getStaff;

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
        } else {
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

    //    查询员工id
    @Override
    public Staff findStaffId(String staffId) {
        String sql = "from Staff CRM_STAFF where staffId = ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, staffId);
        for (Staff staff : list) {
            getStaff = staff;
        }
        return getStaff;
    }

    //    高级查询
    @Override
    public List<Staff> advancedQuery(String depID, String postId, String staffName) {
//        三个都为空
        if (depID.equals("")&&postId.equals("")&&staffName.equals("")) {
            String sql1 = "from Staff crm_staff";
            return (List<Staff>) getHibernateTemplate().find(sql1);
        }
//            前一个不为空,后两个为空
        if (postId.equals("")&&staffName.equals("")) {
            String sql2 = "from Staff crm_staff where post.dep.depID = ?";
            return (List<Staff>) getHibernateTemplate().find(sql2, depID);
        }
//            前两个为空,后一个不为空
        if (depID.equals("")&&postId.equals("")) {
            String sql3 = "from Staff crm_staff where staffName like ?";
            return (List<Staff>) getHibernateTemplate().find(sql3, "%"+staffName+"%");
        }
//            前两个不为空,后一个为空
        if (staffName.equals("")) {
            String sql4 = "from Staff crm_staff where post.dep.depID = ? and post.postId = ?";
            return (List<Staff>) getHibernateTemplate().find(sql4, depID, postId);
        }
//            前一后一不为空,中间为空
        if (postId.equals("")) {
            String sql5 = "from Staff crm_staff where post.dep.depID = ? and staffName like ?";
            return (List<Staff>) getHibernateTemplate().find(sql5, depID, "%"+staffName+"%");
        }
//            都不为空
        String sql6 = "from Staff crm_staff where post.dep.depID = ? and post.postId = ? and staffName like ?";
        return (List<Staff>) getHibernateTemplate().find(sql6, depID, postId, "%"+staffName+"%");

    }

    //    更改密码
    @Override
    public void LoginPwd(Staff staff, String oldPassword) {
        List<Staff> staffList = (List<Staff>) getHibernateTemplate().find("from Staff staff where staff.loginName=?", staff.getLoginName());
        if (staffList.size() > 0) {
            Staff staff1 = staffList.get(0);
            staff1.setLoginPwd(oldPassword);
            getHibernateTemplate().update(staff1);
        }


    }
}
