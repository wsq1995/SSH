package com.lanou.staff.domain;

/**
 * Created by dllo on 17/11/9.
 */
public class Staff {
    private String staffId;
    private String loginName;
    private String loginPwd;
    private String staffName;
    private String gender;
    private String onDutyDate;
    private Department dep;
    private Post post;

    public Staff() {
    }

    public Staff( String staffName, String gender) {
        this.staffName = staffName;
        this.gender = gender;
    }

    public Staff(String staffId, String loginName,
                 String loginPwd, String staffName, String gender,
                 String onDutyDate) {
        this.staffId = staffId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;
    }

    public Staff(String loginName, String loginPwd,
                 String staffName, String gender, String onDutyDate) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(Department dep) {
        this.dep = dep;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
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

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(String onDutyDate) {
        this.onDutyDate = onDutyDate;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", staffName='" + staffName + '\'' +
                ", gender='" + gender + '\'' +
                ", onDutyDate='" + onDutyDate + '\'' +
                '}';
    }
}
