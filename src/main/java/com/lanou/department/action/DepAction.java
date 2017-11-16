package com.lanou.department.action;

import com.lanou.department.service.DepService;
import com.lanou.staff.domain.Department;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */

public class DepAction extends ActionSupport implements ModelDriven<Department> {

    private Department department = new Department();

    @Resource
    private DepService depService;
    private String depName;
    private List<Department> deps;


    //    添加部门
    public String save() {
        System.out.println(department);
        depService.save(department);
//        ActionContext.getContext().put("dep", deps);
        return SUCCESS;
    }

    //    查询所有部门
    public String listDep() {
        deps = depService.listDep();
        ActionContext.getContext().put("deps",deps);
        return SUCCESS;
    }

    //    编辑部门
    public String editDep() {
        depService.editDep(department);
        return SUCCESS;
    }


    public void setDepService(DepService depService) {
        this.depService = depService;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<Department> getDeps() {
        return deps;
    }

    public void setDeps(List<Department> deps) {
        this.deps = deps;
    }

    @Override
    public Department getModel() {
        return department;
    }
}
