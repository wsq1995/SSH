package com.lanou.post.action;

import com.lanou.base.BaseAction;
import com.lanou.post.service.PostService;
import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class PostAction extends BaseAction<Post, PostService> {

    private PostService postService;
    private List<Post> posts;
    private List<Department> departmentList;

    //    查询职务
    public String queryPost() {
        posts = postService.queryPost(getModel());
        return SUCCESS;
    }

    //    添加职务
    public String addPost() {
        getModel().setDep(new Department(getModel().getDep().getDepID()));
        posts = postService.addPost(getModel());
        return SUCCESS;
    }

    //    根据部门id找职务
    public String findPostToDepID() {
        List<Post> pId = postService.findPostToDepID(getModel().getDep().getDepID());
        ActionContext.getContext().getSession().put("postId", pId.get(0));
        return SUCCESS;
    }

//    查询所有部门
    public String findDepartment() {
        departmentList = postService.findDepartment();
        return SUCCESS;
    }



    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}

