package com.lanou.post.dao.impl;

import com.lanou.post.dao.PostDao;
import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    //    添加职务
    @Override
    public List<Post> addPost(Post post) {
        String postId = post.getPostId();
//        如果id为空,就添加职务,不为空,就编辑职务
        if (postId == null || postId.isEmpty() || post.getPostId() == null) {
            getHibernateTemplate().save(post);
        } else {
            getHibernateTemplate().saveOrUpdate(post);
        }
        return null;
    }

    //    查询职务
    @Override
    public List<Post> queryPost(Post post) {
        String sql = "from Post crm_post";
        List<Post> list = (List<Post>) getHibernateTemplate().find(sql);
        return list;
    }

    //    编辑职务
    @Override
    public void editPost(Post post) {
        getHibernateTemplate().saveOrUpdate(post);
    }

    @Override
    public List<Post> findPostToDepID(String depID) {
        String sql = "from Post crm_post where dep.depID = ?";
        List<Post> posts = (List<Post>) getHibernateTemplate().find(sql, depID);
        return posts;
    }

//    查询所有部门
    @Override
    public List<Department> findDepartment() {
        return (List<Department>) getHibernateTemplate().find("from Department  dept");
    }


}
