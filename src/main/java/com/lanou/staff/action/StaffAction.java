package com.lanou.staff.action;
import com.lanou.department.service.DepService;
import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.impl.StaffServiceImpl;
import com.lanou.staff.utils.BaseAction;
import com.lanou.staff.utils.MD5Util;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by dllo on 17/11/9.
 */
public class StaffAction extends BaseAction<Staff,StaffServiceImpl> {

    private String find_staffId;

    private List<Staff> staffs;
    private List<Department> deps;
    private String reNewPassword;
    private String newPassword;
    private String oldPassword;
//    接受页面传过来额的值
    private String depID;
    private String postId;
    private String staffName;
    private List<Post>post1;

    // 这个是editStaff.jsp页面取到的值
    private Staff staffId1;
    private List<Staff> staffList;


    //    登录
    public String login() {
//        getModel().setLoginPwd(MD5Util.MD5(getModel().getLoginPwd()));
            staffs = service.login(getModel());
        if (staffs.isEmpty()) {
            addFieldError("msg", "请登录");
            return INPUT;
        }
        sessionPut("loginName", staffs.get(0).getLoginName());
        sessionPut("staffss",staffs.get(0));
        return SUCCESS;

    }

    //    查询员工
    @SkipValidation
    public String query() {
        staffs = service.query();
        ActionContext.getContext().put("sta", staffs);
        return SUCCESS;
    }

    //    根据部门id查询职务
    @SkipValidation
    public String findPostByDepID() {
        post1 = service.findPostByDepID(depID);
        return SUCCESS;
    }

    //    添加员工
    @SkipValidation
    public String saveStaff() {
        if (getModel().getStaffId() == null || getModel().getStaffId().isEmpty()) {
            getModel().setDep(new Department(depID));
            getModel().setPost(new Post(postId));
            staffs = service.saveStaff(getModel());
        } else {
            saveOrUpDate();
        }
        return SUCCESS;
    }

    //    编辑员工
    @SkipValidation
    public String saveOrUpDate() {
        service.saveOrUpdate(getModel());
        return SUCCESS;
    }

    @Resource
    private DepService depService;

    //查询员工id
    @SkipValidation
    public String findStaffId() {
        deps = depService.listDep();
        staffId1 = service.findStaffId(find_staffId);
        return SUCCESS;
    }

    //高级查询
    @SkipValidation
    public String advancedQuery() {
        String depId = getModel().getPost().getDep().getDepID();
        String postId = getModel().getPost().getPostId();
        String staffName = getModel().getStaffName();
        staffList= service.advancedQuery(depId, postId, staffName);
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

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Post> getPost1() {
        return post1;
    }

    public void setPost1(List<Post> post1) {
        this.post1 = post1;
    }

}
