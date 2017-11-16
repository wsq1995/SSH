package com.lanou.post.action;

import com.lanou.post.service.PostService;
import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class PostAction extends ActionSupport implements ModelDriven<Post> {
    Post post = new Post();
    private PostService postService;
    private List<Post> posts;

    private String depID;
    private String depName;
    private String postId;


    //    查询职务
    public String queryPost() {
        posts = postService.queryPost(post);
        return SUCCESS;
    }

    public String addPost() {
        //    添加职务
        if (postId == null || postId.equals("")) {
            post.setDep(new Department(depID));
            posts = postService.addPost(post);
            return SUCCESS;
        } else {
            //    编辑职务
            post.setDep(new Department(depID));
            postService.editPost(post);
            return SUCCESS;
        }
    }


    @Override
    public Post getModel() {
        return post;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
