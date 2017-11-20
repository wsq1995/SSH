package com.lanou.department.action;
import com.lanou.department.dao.DepDao;
import com.lanou.department.service.DepService;
import com.lanou.staff.domain.Department;
import com.lanou.staff.utils.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Scope("prototype")
public class DepAction extends BaseAction<Department, DepService> {

    private List<Department> deps;
    private String staffId;


    //    添加部门
    public String save() {
        service.save(getModel());
        return SUCCESS;
    }

    //    查询所有部门
    public String listDep() {
        deps = service.listDep();
        ActionContext.getContext().getSession().put("deps", deps);
        return SUCCESS;
    }

    //    编辑部门
    public String editDep() {
        service.editDep(getModel());
        return SUCCESS;
    }

//    通过id查找部门
    public String findDepID(){
        List<Department> depIDs = service.findDepID(getModel().getDepID());
        ActionContext.getContext().put("depIdS",depIDs.get(0));
        return SUCCESS;
    }

    public List<Department> getDeps() {
        return deps;
    }

    public void setDeps(List<Department> deps) {
        this.deps = deps;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }


}
