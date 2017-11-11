package com.lanou.department.dao.impl;

import com.lanou.department.dao.DepDao;
import com.lanou.staff.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring.xml")
public class DepDaoImplTest {
    @Resource
    private DepDao depDao;
    @Test
    public void addDepTest(){
        Department dep= new Department("咨询部");
        depDao.save(dep);
    }

//    @Test
//    public void updateDep(){
//        depDao.updateDep("")
//    }


}