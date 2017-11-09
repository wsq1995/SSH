package com.lanou.staff.action;

import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/9.
 */
@Controller
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    private Staff staff = new Staff();

    @Resource
    private StaffService staffService;

    public String login() {


        return SUCCESS;


    }


    @Override
    public Staff getModel() {
        return staff;
    }



}
