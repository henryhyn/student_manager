package com.nengjun.student.manager.dao;

import com.nengjun.student.manager.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;

/**
 * Created by Henry on 16/8/6.
 */
public class HibernateDao {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static ArrayList<Student> findAll() {
        ArrayList<Student> result = new ArrayList<Student>();
        Session session = HibernateDao.getSession();
        Query query = session.createQuery("from Student");
        for (Object object : query.list()) {
            result.add((Student) object);
        }
        return result;
    }

    public static Student find(Integer id) {
        Student result = null;
        Session session = HibernateDao.getSession();
        Query query = session.createQuery("from Student where id=" + id);
        for (Object object : query.list()) {
            result = (Student) object;
        }
        return result;
    }

    public static Student first() {
        Student result = null;
        Session session = HibernateDao.getSession();
        Query query = session.createQuery("from Student").setMaxResults(1);
        for (Object object : query.list()) {
            result = (Student) object;
        }
        return result;
    }

    public static Student last() {
        Student result = null;
        Session session = HibernateDao.getSession();
        Query query = session.createQuery("from Student order by id desc").setMaxResults(1);
        for (Object object : query.list()) {
            result = (Student) object;
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
