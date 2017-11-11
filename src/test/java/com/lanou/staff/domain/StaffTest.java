package com.lanou.staff.domain;

import com.lanou.staff.dao.StaffDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring.xml")
public class StaffTest {
    @Resource
    private StaffDao staffDao;
    @Test
    public void test(){
        Department dep = new Department("教学部");
        Post post = new Post("教学总监");
        post.setDep(dep);

        Staff staff = new Staff("zhangsan","男");
        staff.setDep(dep);
        staff.setLoginPwd("123");
        staff.setLoginName("123");
        staff.setPost(post);
        staffDao.add(staff);
    }


}