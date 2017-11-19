package com.lanou.staff.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffActionInterceptor extends MethodFilterInterceptor{

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object login = ServletActionContext.getContext().getSession().get("loginName");
        if (login == null){
            return "login";
        }
        return actionInvocation.invoke();
    }
}
