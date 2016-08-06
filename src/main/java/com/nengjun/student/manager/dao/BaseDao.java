package com.nengjun.student.manager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Henry on 16/8/6.
 */
public class BaseDao<T> {
    private SessionFactory sessionFactory;

    private Class entityClass;

    public BaseDao() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class aClass = (Class) type.getActualTypeArguments()[0];
        entityClass = aClass;
    }

    public List<T> findAll() {
        Session session = getSession();
        List<T> list = session.createQuery("from " + entityClass.getName()).list();
        session.close();
        return list;
    }

    public T find(Serializable id) {
        Session session = getSession();
        T entity = (T) session.get(entityClass, id);
        session.close();
        return entity;
    }

    public T first() {
        Session session = getSession();
        T entity = (T) session.createQuery("from " + entityClass.getName()).setMaxResults(1).list().get(0);
        session.close();
        return entity;
    }

    public T last() {
        Session session = getSession();
        T entity = (T) session.createQuery("from " + entityClass.getName()).setMaxResults(1).list().get(0);
        session.close();
        return entity;
    }

    public void load(T entity, Serializable id) {
        Session session = getSession();
        session.load(entity, id);
        session.close();
    }

    public void save(T entity) {
        Session session = getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void update(T entity) {
        Session session = getSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
