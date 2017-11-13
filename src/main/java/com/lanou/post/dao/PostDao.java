package com.lanou.post.dao;

import com.lanou.staff.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface PostDao {
//    添加职务
    List<Post> addPost(Post post);
//    查询职务
    List<Post> queryPost(Post post);
//    编辑职务
    void editPost(Post post);

}
