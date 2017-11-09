package com.lanou.staff.domain;

import com.lanou.staff.dao.StaffDao;
import com.lanou.staff.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class StaffTest {
    @Resource
    private StaffDao staffDao;
    @Test
    public void test(){

        Department dep = new Department("教学部");
        Post post = new Post("教学总监");
        post.setDep(dep);

        Staff staff = new Staff("孟宪义","男");
        staff.setDep(dep);
        staff.setPost(post);
        staffDao.login(staff);
    }


}