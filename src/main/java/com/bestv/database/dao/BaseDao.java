package com.bestv.database.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 13-10-25
 * Time: 下午2:53
 * To change this template use File | Settings | File Templates.
 */
public class BaseDao<T> {
    private SessionFactory sessionFactory;

    private Class entityClass;

    public BaseDao() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class aClass = (Class) type.getActualTypeArguments()[0];
        setEntityClass(aClass);
    }

    public List<T> findAll() {
        Session session = getSession();
        List<T> list = session.createQuery("from " + getEntityClass().getName()).list();
        session.close();
        return list;
    }

    public T find(Serializable id) {
        Session session = getSession();
        T t = (T) session.get(getEntityClass(), id);
        session.close();
        return t;
    }

    public void save(T t) {
        Session session = getSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    public void update(T t) {
        Session session = getSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T t) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }
}
