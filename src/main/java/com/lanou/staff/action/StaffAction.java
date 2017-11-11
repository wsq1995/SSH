package com.lanou.staff.action;

import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Controller
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    private Staff staff = new Staff();
    private String loginName;
    private String loginPwd;

    @Resource
    private StaffService staffService;
    private List<Staff> list;

    public String login() {
        list = staffService.login(staff);
        ActionContext.getContext().getSession().put("loginName",list.get(0).getLoginName());
        if (list.isEmpty()){
            addFieldError("msg","请登录");
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public Staff getModel() {
        return staff;
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



    public List<Staff> getList() {
        return list;
    }

    public void setList(List<Staff> list) {
        this.list = list;
    }
}
