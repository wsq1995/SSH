package com.lanou.staff.service.impl;

import com.lanou.staff.dao.StaffDao;
import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    @Override
    public List<Staff> login(Staff staff) {
        return staffDao.login(staff);
    }

    //    查询员工
    @Override
    public List<Staff> query() {
        List<Staff> list = staffDao.query();
        return list;
    }

    //    根据部门id查职务
    @Override
    public List<Post> findPostByDepID(String depID) {
        return staffDao.findPostByDepID(depID);
    }

    //    添加员工
    @Override
    public List<Staff> saveStaff(Staff staff) {
        staffDao.saveStaff(staff);
        return null;
    }

    //    编辑员工
    @Override
    public List<Staff> saveOrUpdate(Staff staff) {
        return staffDao.saveStaff(staff);
    }

    //    查询员工id
    @Override
    public Staff findStaffId(String staffId) {
        return staffDao.findStaffId(staffId);
    }

    @Override
    public List<Staff> advancedQuery(String depID, String postId, String staffName) {
        return staffDao.advancedQuery(depID,postId,staffName);
    }

    @Override
    public void LoginPwd(Staff staff, String oldPassword) {
         staffDao.LoginPwd(staff,oldPassword);
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
