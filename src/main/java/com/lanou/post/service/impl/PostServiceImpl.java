package com.lanou.post.service.impl;

import com.lanou.post.dao.PostDao;
import com.lanou.post.service.PostService;
import com.lanou.staff.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public class PostServiceImpl implements PostService{
    private PostDao postDao;
//    添加职务
    @Override
    public List<Post> addPost(Post post) {
        return postDao.addPost(post);
    }

//    查询职务
    @Override
    public List<Post> queryPost(Post post) {
        return postDao.queryPost(post);
    }

//    编辑职务
    @Override
    public void editPost(Post post) {
        postDao.editPost(post);
    }

    @Override
    public List<Post> findPostToDepID(String depID) {
        return postDao.findPostToDepID(depID);
    }


    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
