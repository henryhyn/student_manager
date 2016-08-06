package com.nengjun.student.manager.dao.impl;

import com.nengjun.student.manager.dao.StudentDao;
import com.nengjun.student.manager.entity.Student;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.Collection;
import java.util.List;

/**
 * Created by Henry on 16/8/6.
 */
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {
    public Student findOne(Integer id) {
        return getHibernateTemplate().get(Student.class, id);
    }

    @Override
    public List<Student> all() {
        return null;
    }

    @Override
    public Student find(Long id) {
        return null;
    }

    @Override
    public List<Student> find(Long... ids) {
        return null;
    }

    @Override
    public Student load(Long id) {
        return null;
    }

    @Override
    public List<Student> load(Long... ids) {
        return null;
    }

    @Override
    public Student take() {
        return null;
    }

    @Override
    public List<Student> take(int limit) {
        return null;
    }

    public Student first() {
        Session session = getSessionFactory().openSession();
        Student student = (Student) session.createQuery("from " + Student.class.getName()).setMaxResults(1).list().get(0);
        session.close();
        return student;
    }

    @Override
    public List<Student> first(int limit) {
        return null;
    }

    @Override
    public Student last() {
        return null;
    }

    @Override
    public List<Student> last(int limit) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public void destroy(Student entity) {

    }

    @Override
    public void destroy(Long id) {

    }

    @Override
    public void destroy(Collection<Student> entities) {

    }

    @Override
    public void save(Student entity) {

    }

    @Override
    public void save(Collection<Student> entities) {

    }
}
