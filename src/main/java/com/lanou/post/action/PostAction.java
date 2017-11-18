package com.lanou.post.action;

import com.lanou.base.BaseAction;
import com.lanou.post.dao.PostDao;
import com.lanou.post.service.PostService;
import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class PostAction extends BaseAction<Post, PostService> {

    private PostService postService;
    private List<Post> posts;

    //    查询职务
    public String queryPost() {
        posts = postService.queryPost(getModel());
        return SUCCESS;
    }

    //    添加职务
    public String addPost() {
        if (getModel().getPostId() == null || getModel().getPostId().equals("")) {
            getModel().setDep(new Department(getModel().getDep().getDepID()));
            posts = postService.addPost(getModel());
            return SUCCESS;
        } else {
//   编辑职务
            getModel().setDep(new Department(getModel().getDep().getDepID()));
            postService.editPost(getModel());
            return SUCCESS;
        }
    }

    //    根据部门id找职务
    public String findPostToDepID() {
        List<Post> postId = postService.findPostToDepID(getModel().getDep().getDepID());
        ActionContext.getContext().getSession().put("postId",postId.get(0));
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
}

//    Post post = new Post();
//    private PostService postService;
//    private List<Post> posts;
//
//    private String depID;
//    private String depName;
//    private String postId;

//    public String getDepID() {
//        return depID;
//    }
//
//    public void setDepID(String depID) {
//        this.depID = depID;
//    }
//
//    public String getDepName() {
//        return depName;
//    }
//
//    public void setDepName(String depName) {
//        this.depName = depName;
//    }
//
//    public PostService getPostService() {
//        return postService;
//    }
//
//    public void setPostService(PostService postService) {
//        this.postService = postService;
//    }
//
//    public List<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }
//
//    public Post getPost() {
//        return post;
//    }
//
//    public void setPost(Post post) {
//        this.post = post;
//    }
//
//    public String getPostId() {
//        return postId;
//    }
//
//    public void setPostId(String postId) {
//        this.postId = postId;
//    }
