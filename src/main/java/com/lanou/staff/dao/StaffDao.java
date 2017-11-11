package com.lanou.staff.dao;

import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffDao {
    List<Staff> login(Staff staff);
    List<Staff> query(Staff staff);
    List<Staff> update(Staff staff);
    List<Staff> add(Staff staff);
    List<Staff> delete(Staff staff);





}
