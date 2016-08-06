package com.nengjun.student.manager.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Henry on 16/8/6.
 */
public interface GenericDao<T, PK extends Serializable> {
    List<T> all();

    T find(final PK id);

    List<T> find(final PK... ids);

    T load(final PK id);

    List<T> load(final PK... ids);

    T take();

    List<T> take(int limit);

    T first();

    List<T> first(int limit);

    T last();

    List<T> last(int limit);

    boolean exists(final PK id);

    void destroy(T entity);

    void destroy(final PK id);

    void destroy(Collection<T> entities);

    void save(T entity);

    void save(Collection<T> entities);
}
