package com.lanou.staff.action;

import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by dllo on 17/11/9.
 */
@Controller
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    private Staff staff = new Staff();
    private Department deps;
    //    用来接收前端页面传过来的值
    private String loginName;
    private String loginPwd;

    //    接收前段穿过来的id;
    private String depID;
    private String postId;
    private String staffId;

    @Resource
    private StaffService staffService;
    private List<Staff> staffs;
    private List<Post> posts1;

    public String login() {
        staffs = staffService.login(staff);
        ActionContext.getContext().getSession().put("loginName", staffs.get(0).getLoginName());
        if (staffs.isEmpty()) {
            addFieldError("msg", "请登录");
            return ERROR;
        }
        return SUCCESS;
    }

    //    查询员工
    public String query() {
        staffs = staffService.query();
        return SUCCESS;
    }

    //    根据部门id查询职务
    public String findPostByDepID() {
        posts1 = staffService.findPostByDepID(depID);
        return SUCCESS;
    }

    //    添加员工
    public String saveStaff() {
        if (staffId == null || staffId.isEmpty()) {
            staff.setDep(new Department(depID));
            staff.setPost(new Post(postId));
            staffs = staffService.saveStaff(staff);
        } else {
            staffService.saveOrUpdate(staff);
        }
        return SUCCESS;
    }

    //    编辑员工
    public String saveOrUpDate() {
        staffService.saveOrUpdate(staff);
        return SUCCESS;
    }


    @Override
    public Staff getModel() {
        return staff;
    }


    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public StaffService getStaffService() {
        return staffService;
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Department getDeps() {
        return deps;
    }

    public void setDeps(Department deps) {
        this.deps = deps;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public List<Post> getPosts1() {
        return posts1;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
