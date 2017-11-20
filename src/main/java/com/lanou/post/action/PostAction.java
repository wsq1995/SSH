package com.lanou.post.action;
import com.lanou.post.service.PostService;
import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;
import com.lanou.staff.utils.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Scope("prototype")
public class PostAction extends BaseAction<Post, PostService> {

    private List<Post> posts;
    private List<Department> departmentList;

    //    查询职务
    public String queryPost() {
        posts = service.queryPost(getModel());
        return SUCCESS;
    }

    //    添加职务
    public String addPost() {
        getModel().setDep(new Department(getModel().getDep().getDepID()));
        posts = service.addPost(getModel());
        return SUCCESS;
    }

    //    根据部门id找职务
    public String findPostToDepID() {
        List<Post> pId = service.findPostToDepID(getModel().getDep().getDepID());
        ActionContext.getContext().getSession().put("postId", pId.get(0));
        return SUCCESS;
    }

//    查询所有部门
    public String findDepartment() {
        departmentList = service.findDepartment();
        return SUCCESS;
    }



    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}

