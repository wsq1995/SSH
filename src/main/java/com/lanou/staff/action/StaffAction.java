package com.lanou.staff.action;

import com.lanou.base.BaseAction;
import com.lanou.department.service.DepService;
import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;
import com.lanou.staff.utils.MD5Util;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by dllo on 17/11/9.
 */
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff, StaffService> {

    private String find_staffId;

    @Resource
    private StaffService staffService;
    private List<Staff> staffs;
    private List<Post> posts1;
    private List<Department> deps;
    private String reNewPassword;
    private String newPassword;
    private String oldPassword;

    // 这个是editStaff.jsp页面取到的值
    private Staff staffId1;


    //    登录
    public String login() {
//        getModel().setLoginPwd(MD5Util.MD5(getModel().getLoginPwd()));
        staffs = staffService.login(getModel());
        sessionPut("loginName", staffs.get(0).getLoginName());
        sessionPut("staffss",staffs.get(0));
        if (staffs.isEmpty()) {
            addFieldError("msg", "请登录");
            return INPUT;
        } else return SUCCESS;

    }

    //    查询员工
    @SkipValidation
    public String query() {
        staffs = staffService.query();
        ActionContext.getContext().put("sta", staffs);
        return SUCCESS;
    }

    //    根据部门id查询职务
    @SkipValidation
    public String findPostByDepID() {
        posts1 = staffService.findPostByDepID(getModel().getDep().getDepID());
        return SUCCESS;
    }

    //    添加员工
    @SkipValidation
    public String saveStaff() {
        if (getModel().getStaffId() == null || getModel().getStaffId().isEmpty()) {
            getModel().setDep(new Department(getModel().getDep().getDepID()));
            getModel().setPost(new Post(getModel().getPost().getPostId()));
            staffs = staffService.saveStaff(getModel());
        } else {
            saveOrUpDate();
        }
        return SUCCESS;
    }

    //    编辑员工
    @SkipValidation
    public String saveOrUpDate() {
        staffService.saveOrUpdate(getModel());
        return SUCCESS;
    }

    @Resource
    private DepService depService;

    //查询员工id
    @SkipValidation
    public String findStaffId() {
        deps = depService.listDep();
        staffId1 = staffService.findStaffId(find_staffId);
        return SUCCESS;
    }

    //高级查询
    @SkipValidation
    public String advancedQuery() {
        String depId = getModel().getPost().getDep().getDepID();
        String postId = getModel().getPost().getPostId();
        String staffName = getModel().getStaffName();
        staffService.advancedQuery(depId, postId, staffName);
        return SUCCESS;
    }


    //更改密码
    @SkipValidation
    public String updateLoginPwd() {
        Staff sta = (Staff) ActionContext.getContext().getSession().get("staffss");
        if (!oldPassword.equals(sta.getLoginPwd()) || !newPassword.equals(reNewPassword)) {
            addActionError("密码输入错误");
            return ERROR;
        } else {
            service.LoginPwd(sta, reNewPassword);
            return SUCCESS;
        }
    }


    //    重新登录
    @SkipValidation
    public String reLogin() {
        ActionContext.getContext().getSession().remove("loginName");
        return "success";
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

    public String getFind_staffId() {
        return find_staffId;
    }

    public void setFind_staffId(String find_staffId) {
        this.find_staffId = find_staffId;
    }

    public List<Department> getDeps() {
        return deps;
    }

    public Staff getStaffId1() {
        return staffId1;
    }

    public void setStaffId1(Staff staffId1) {
        this.staffId1 = staffId1;
    }

    public List<Post> getPosts1() {
        return posts1;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
