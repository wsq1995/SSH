package com.lanou.staff.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by dllo on 17/11/2.
 */
public class HibernateUtil {
    private static final SessionFactory SF;
    static {
        try {
            SF = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("配置文件错误");
        }
    }
    public static Session openSession(){
        Session session = SF.getCurrentSession();
//        直接开启事务
        session.beginTransaction();
        return session;
    }

    public static void commit(){
        SF.getCurrentSession().getTransaction().commit();
    }

}
