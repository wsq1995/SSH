package com.lanou.staff.dao;

import com.lanou.staff.domain.Post;
import com.lanou.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface StaffDao {
    List<Staff> login(Staff staff);

    //    查询员工
    List<Staff> query();

    //    根据部门id查询职务
    List<Post> findPostByDepID(String depID);

    //    添加员工
    List<Staff> saveStaff(Staff staff);

    //    编辑员工
    List<Staff> saveOrUpdata(Staff staff);

    //    查员工id
    Staff findStaffId(String staffId);

    //    高级查询
    void advancedQuery(String depID, String postId, String staffName);

}
