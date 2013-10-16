package com.bestv.utils.database;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 13-10-17
 * Time: 上午12:10
 * To change this template use File | Settings | File Templates.
 */
public class JDBCHelper {
    public static Connection getConnection(String dbDriver, String dbUrl, String dbUserName, String dbPassword) throws SQLException {
        if (!DbUtils.loadDriver(dbDriver)) {
            throw new SQLException("Error on load JDBC driver: " + dbDriver);
        }
        return DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
    }
}
