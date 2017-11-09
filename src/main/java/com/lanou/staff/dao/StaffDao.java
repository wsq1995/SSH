package com.lanou.staff.dao;

import com.lanou.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffDao {
    void login(Staff staff);
    List<Staff> query(Staff staff);
    List<Staff> update(Staff staff);




}
