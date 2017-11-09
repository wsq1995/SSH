package com.lanou.staff.service;

import com.lanou.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffService {
    List<Staff> login(String loginName,String loginPwd);
    List<Staff> query(Staff staff);
    List<Staff> update(Staff staff);


}
