package com.bestv.database.dao;

/**
 * DAO 工厂
 * User: henry
 * Date: 13-9-11
 * Time: 下午4:02
 */
public class DaoFactory {
    private static StudentDao studentDao = null;
    public static StudentDao getStudentDao() {
        if (studentDao == null) {
            studentDao = new StudentDao();
        }
        return studentDao;
    }
}
