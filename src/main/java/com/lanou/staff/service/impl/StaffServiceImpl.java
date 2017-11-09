package com.lanou.staff.service.impl;

import com.lanou.staff.dao.StaffDao;
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
    public List<Staff> login(String loginName, String loginPwd) {
        return null;
    }

    @Override
    public List<Staff> query(Staff staff) {
        return null;
    }

    @Override
    public List<Staff> update(Staff staff) {
        return null;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
