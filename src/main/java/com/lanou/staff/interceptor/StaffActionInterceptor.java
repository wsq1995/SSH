package com.lanou.staff.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by dllo on 17/11/10.
 */
public class StaffActionInterceptor extends AbstractInterceptor {
    private String loginName;
    private String loginPwd;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        if (loginName == null || loginName.equals("") && loginPwd == null || loginPwd.equals("")){
            return "input";
        }
        else {
            return invocation.invoke();
        }
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
}
