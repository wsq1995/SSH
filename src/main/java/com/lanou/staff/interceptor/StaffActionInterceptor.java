package com.lanou.staff.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffActionInterceptor extends MethodFilterInterceptor{

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        String attribute = (String) ServletActionContext.getServletContext().getAttribute("loginName");
        if ("".equals(attribute)){
            return "input";
        }
        return actionInvocation.invoke();
    }
}
