package com.lanou.page.dao.impl;

import com.lanou.page.dao.PageDao;
import com.lanou.post.dao.PostDao;
import com.lanou.staff.domain.Department;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/17.
 */
public class PageDaoImpl extends HibernateDaoSupport implements PageDao {
    //    获取所有记录条数
    @Override
    public int getTotalRecord(String condition, Object[] params) {
        String sql1 = "from Department crm_department where 1=1" + condition;
        List<Long> find = (List<Long>) getHibernateTemplate().find(sql1, params);
        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Department> findAll(String condition, Object[] params, int startIndex, int pageSize) {
        String sql2 = "from Department crm_department where 1=1" + condition;
//        sql是没有分页的函数的,可以使用excute来实现
        return getHibernateTemplate().execute(
                new PageHibernateCallback<Department>(sql2,params,startIndex,pageSize));
    }
}
