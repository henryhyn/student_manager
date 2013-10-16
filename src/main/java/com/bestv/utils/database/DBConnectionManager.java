package com.bestv.utils.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 13-10-17
 * Time: 上午12:14
 * To change this template use File | Settings | File Templates.
 */
public class DBConnectionManager {
    private static Logger logger = LoggerFactory.getLogger(DBConnectionManager.class);

    private static String dbDriver = "com.mysql.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/student_manager?useUnicode=true&characterEncoding=utf-8";
    private static String dbUserName = "root";
    private static String dbPassword = "mysql";

    public static synchronized Connection getConnection() {
        Connection connection = null;
        try {
            connection = JDBCHelper.getConnection(dbDriver, dbUrl, dbUserName, dbPassword);
        } catch (SQLException e) {
            logger.error("Error on create connection.", e);
        }
        return connection;
    }
}