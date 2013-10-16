package com.bestv.database.dao;

import com.bestv.database.vo.Student;

import java.util.ArrayList;

/**
 * 节目 DAO 层接口
 * User: henry
 * Date: 13-9-11
 * Time: 下午3:58
 */
public interface StudentDao {
    public ArrayList<Student> findAll();

    public Student find(Integer id);

    public void save(Student student);

    public void update(Student student);

    public void delete(Student student);
}
