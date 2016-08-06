package com.nengjun.avatar.commons.db;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Henry on 16/8/6.
 */
@Slf4j
public class DBConnectionManager {
    private static String dbDriver = "com.mysql.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/student_manager?useUnicode=true&characterEncoding=utf-8";
    private static String dbUserName = "root";
    private static String dbPassword = "mysql";

    public static synchronized Connection getConnection() {
        Connection connection = null;
        try {
            connection = JDBCHelper.getConnection(dbDriver, dbUrl, dbUserName, dbPassword);
        } catch (SQLException e) {
            log.error("Error on create connection.", e);
        }
        return connection;
    }
}
