package com.nengjun.student.manager.dao.hibernate;

import com.nengjun.student.manager.dao.StudentDao;
import com.nengjun.student.manager.entity.Student;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 16/8/6.
 */
@Repository("studentDao")
public class StudentDaoHibernate extends GenericDaoHibernate<Student, Long> implements StudentDao {
}
