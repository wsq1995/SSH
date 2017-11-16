package com.lanou.staff.action;

import com.lanou.department.service.DepService;
import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.ApplicationContext;
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

    //    用来接收前端页面传过来的值
    private String loginName;
    private String loginPwd;

    //    接收前段穿过来的id;
    private String depID;
    private String postId;
    private String staffId;
    private String find_staffId;
    private String staffName;

    @Resource
    private StaffService staffService;

    private List<Staff> staffs;
    private List<Post> posts1;
    private List<Department> deps;
    //    这个是editStaff.jsp页面取到的值
    private Staff staffId1;

    //    登录
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
        ActionContext.getContext().put("sta",staffs);
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
            saveOrUpDate();
        }
        return SUCCESS;
    }

    //    编辑员工
    public String saveOrUpDate() {
        staffService.saveOrUpdate(staff);
        return SUCCESS;
    }

    @Resource
    private DepService depService;

    //    查询员工id
    public String findStaffId() {
        deps = depService.listDep();
        staffId1 = staffService.findStaffId(find_staffId);
        return SUCCESS;
    }

    //    高级查询
    public String advancedQuery() {
        staffService.advancedQuery(depID, postId, staffName);
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

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
