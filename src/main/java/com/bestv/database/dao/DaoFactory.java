package com.bestv.database.dao;

import com.bestv.database.dao.impl.StudentDaoImpl;

/**
 * DAO 工厂
 * User: henry
 * Date: 13-9-11
 * Time: 下午4:02
 */
public class DaoFactory {
    public static StudentDao getStudentDao() {
        return new StudentDaoImpl();
    }
}
