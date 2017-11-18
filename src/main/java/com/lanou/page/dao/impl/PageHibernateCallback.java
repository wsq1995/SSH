package com.lanou.page.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

/**
 * Created by dllo on 17/11/17.
 */
//HibernateCallback的实现类
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {
    private String sql;//sql语句
    private Object[]params;//参数
    private int startIndex;//开始索引
    private int pageSize;//每页显示的条目数

    public PageHibernateCallback(String sql, Object[] params, int startIndex, int pageSize) {
        this.sql = sql;
        this.params = params;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    @Override
    public List<T> doInHibernate(Session session) throws HibernateException {
        Query query = session.createQuery(sql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i,params[i]);
        }
//        分页
        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);
//        查询所有
        return query.list();
    }
}
