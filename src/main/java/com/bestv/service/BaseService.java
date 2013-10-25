package com.bestv.service;

import com.bestv.database.dao.BaseDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 13-10-25
 * Time: 下午9:46
 * To change this template use File | Settings | File Templates.
 */
public class BaseService<T> {
    private BaseDao baseDao;

    public List<T> findAll() {
        List<T> entities = baseDao.findAll();
        return entities;
    }

    public T find(Serializable id) {
        T entity = (T) baseDao.find(id);
        return entity;
    }

    public void save(T entity) {
        baseDao.save(entity);
    }

    public void update(T entity) {
        baseDao.update(entity);
    }

    public void delete(T entity) {
        baseDao.delete(entity);
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }
}
