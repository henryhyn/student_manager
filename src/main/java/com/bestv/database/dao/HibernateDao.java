package com.bestv.database.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 13-10-25
 * Time: 下午12:08
 * To change this template use File | Settings | File Templates.
 */
public class HibernateDao {
    private SessionFactory sessionFactory;

    private static HibernateDao ourInstance = new HibernateDao();

    public static HibernateDao getInstance() {
        return ourInstance;
    }

    private HibernateDao() {
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public List<Object> findAll(Class aClass) {
        Session session = getSession();
        List<Object> objects = session.createQuery("from " + aClass.getName()).list();
        session.close();
        return objects;
    }

    public Object find(Class aClass, Serializable serializable) {
        Session session = getSession();
        Object object = session.get(aClass, serializable);
        session.close();
        return object;
    }

    public void save(Object object) {
        Session session = getSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Object object) {
        Session session = getSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Object object) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }
}
