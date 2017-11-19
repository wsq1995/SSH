package com.lanou.post.service;

import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public interface PostService {
    //    添加职务
    List<Post> addPost(Post post);

    //    查询职务
    List<Post> queryPost(Post post);

    //    编辑职务
    void editPost(Post post);

    //    根据部门id找职务
    List<Post> findPostToDepID(String depID);
    //    查询部门
    List<Department> findDepartment();
}
