package com.bestv.database.dao.impl;

import com.bestv.database.dao.StudentDao;
import com.bestv.database.vo.Student;
import com.bestv.utils.database.DBConnectionManager;
import com.bestv.utils.database.JDBCHelper;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * 节目 DAO 层类
 * User: henry
 * Date: 13-9-11
 * Time: 下午3:59
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public ArrayList<Student> findAll() {
        String sql = "select id, name, number, class_id from student";
        Connection connection = DBConnectionManager.getConnection();
        ArrayList<Object[]> rows = JDBCHelper.executeQuery(connection, sql);
        ArrayList<Student> result = new ArrayList<Student>();
        for (Object[] row : rows) {
            Student student = new Student();
            student.setId((Integer)row[0]);
            student.setName((String)row[1]);
            student.setNumber((String)row[2]);
            student.setClassId((Integer)row[3]);
            result.add(student);
        }
        JDBCHelper.close(connection);
        return result;
    }

    @Override
    public Student find(Integer id) {
        String sql = "select id, name, number, class_id from student where id=?";
        Connection connection = DBConnectionManager.getConnection();
        ArrayList<Object[]> rows = JDBCHelper.executeQuery(connection, sql, id);
        Object[] row = rows.get(0);
        Student student = new Student();
        student.setId((Integer)row[0]);
        student.setName((String)row[1]);
        student.setNumber((String)row[2]);
        student.setClassId((Integer)row[3]);
        JDBCHelper.close(connection);
        return student;
    }

    @Override
    public void save(Student student) {
        String sql = "insert into student (name,number,class_id) values (?,?,?)";
        Connection connection = DBConnectionManager.getConnection();
        JDBCHelper.executeUpdate(connection, sql, student.getName(), student.getNumber(), student.getClassId());
        JDBCHelper.close(connection);
    }

    @Override
    public void update(Student student) {
        String sql = "update student set name=?, number=?, class_id=? where id=?";
        Connection connection = DBConnectionManager.getConnection();
        JDBCHelper.executeUpdate(connection, sql, student.getName(), student.getNumber(), student.getClassId(),student.getId());
        JDBCHelper.close(connection);
    }

    @Override
    public void delete(Student student) {
        String sql = "delete from student where id=?";
        Connection connection = DBConnectionManager.getConnection();
        JDBCHelper.executeUpdate(connection, sql, student.getId());
        JDBCHelper.close(connection);
    }
}
