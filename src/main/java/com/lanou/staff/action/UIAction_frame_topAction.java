package com.lanou.staff.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dllo on 17/11/10.
 */
public class UIAction_frame_topAction extends ActionSupport {
    private String loginName;

    public String topUI() throws ServletException, IOException {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        request.setAttribute("loginName",loginName);
        request.getRequestDispatcher("top.jsp").forward(request,response);
        return null;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
