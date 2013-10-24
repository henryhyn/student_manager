package com.bestv.database.dao;

import com.bestv.database.vo.Student;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 13-10-17
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */
public class HibernateDao {
    private static final SessionFactory sessionFactory;

    static {
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public static ArrayList<Student> findAll() {
        ArrayList<Student> result = new ArrayList<Student>();
        Session session = HibernateDao.getSession();
        Query query = session.createQuery("from Student");
        for (Object object : query.list()) {
            result.add((Student)object);
        }
        return result;
    }

    public static Student find(Integer id) {
        Student result = null;
        Session session = HibernateDao.getSession();
        Query query = session.createQuery("from Student where id=" + id);
        for (Object object : query.list()) {
            result = (Student)object;
        }
        return result;
    }

    public static void save(Object object) {
        Session session = getSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }

    public static void update(Object object) {
        Session session = getSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Object object) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }
}
