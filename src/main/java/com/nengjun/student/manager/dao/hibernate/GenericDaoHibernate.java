package com.nengjun.student.manager.dao.hibernate;

import com.nengjun.student.manager.dao.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

/**
 * Created by Henry on 16/8/6.
 */
public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SessionFactory sessionFactory;
    private Class entityClass;

    public GenericDaoHibernate() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        entityClass = (Class) type.getActualTypeArguments()[0];
    }

    @Override
    public List<T> all() {
        return getByCriteria();
    }

    @Override
    public T find(final PK id) {
        Session session = getSession();
        session.beginTransaction();
        T entity = (T) session.get(entityClass, id);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public List<T> find(PK... ids) {
        return null;
    }

    @Override
    public T load(final PK id) {
        Session session = getSession();
        session.beginTransaction();
        T entity = (T) session.load(entityClass, id);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public List<T> load(PK... ids) {
        return null;
    }

    @Override
    public T take() {
        return null;
    }

    @Override
    public List<T> take(int limit) {
        return null;
    }

    @Override
    public T first() {
        Session session = getSession();
        session.beginTransaction();
        Query query = session.createQuery("from " + entityClass.getName());
        query.setMaxResults(1);
        List<T> entities = (List<T>) query.list();
        T entity = null;
        if (entities.size() > 0) {
            entity = entities.get(0);
        }
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public List<T> first(int limit) {
        return null;
    }

    @Override
    public T last() {
        Session session = getSession();
        session.beginTransaction();
        Query query = session.createQuery("from " + entityClass.getName());
        query.setMaxResults(1);
        List<T> entities = (List<T>) query.list();
        T entity = null;
        if (entities.size() > 0) {
            entity = entities.get(0);
        }
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public List<T> last(int limit) {
        return null;
    }

    @Override
    public boolean exists(final PK id) {
        T entity = find(id);
        return entity != null;
    }

    @Override
    public void destroy(T entity) {
        Assert.notNull(entity);
        Session session = getSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        logger.info("destroy entity: {}", entity);
    }

    @Override
    public void destroy(final PK id) {
        Assert.notNull(id);
        T entity = find(id);
        if (entity != null) {
            destroy(entity);
        }
    }

    @Override
    public void destroy(Collection<T> entities) {
        Session session = getSession();
        session.beginTransaction();
        for (T entity : entities) {
            session.delete(entity);
        }
        session.getTransaction().commit();
    }

    @Override
    public void save(T entity) {
        Assert.notNull(entity);
        Session session = getSession();
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        logger.info("save entity: {}", entity);
    }

    @Override
    public void save(Collection<T> entities) {
        Session session = getSession();
        session.beginTransaction();
        for (T entity : entities) {
            session.saveOrUpdate(entity);
        }
        session.getTransaction().commit();
    }

    public Query createQuery(String hql, Object... values) {
        Assert.hasText(hql);
        Query query = getSession().createQuery(hql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query;
    }

    public List<T> getByCriteria(Criterion... criterions) {
        Session session = getSession();
        session.beginTransaction();
        List<T> entities = (List<T>) createCriteria(criterions).list();
        session.getTransaction().commit();
        return entities;
    }

    public Criteria createCriteria(Criterion... criterions) {
        Criteria criteria = getSession().createCriteria(entityClass);
        for (Criterion criterion : criterions) {
            criteria.add(criterion);
        }
        return criteria;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
