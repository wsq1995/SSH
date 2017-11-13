package com.lanou.post.dao.impl;

import com.lanou.post.dao.PostDao;
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
        if (postId == null || post.getPostId().isEmpty()) {
            getHibernateTemplate().save(post);
        } else {
//            如果id不为空,就走编辑方法
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


}
