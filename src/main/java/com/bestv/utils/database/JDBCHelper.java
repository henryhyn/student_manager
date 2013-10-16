package com.bestv.utils.database;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 13-10-17
 * Time: 上午12:10
 * To change this template use File | Settings | File Templates.
 */
public class JDBCHelper {
    private static Logger logger = LoggerFactory.getLogger(JDBCHelper.class);

    public static Connection getConnection(String dbDriver, String dbUrl, String dbUserName, String dbPassword) throws SQLException {
        if (!DbUtils.loadDriver(dbDriver)) {
            throw new SQLException("Error on load JDBC driver: " + dbDriver);
        }
        return DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
    }

    public static void close(Connection conn) {
        DbUtils.closeQuietly(conn);
    }

    public static void close(PreparedStatement pstmt) {
        DbUtils.closeQuietly(pstmt);
    }

    public static void close(Statement stmt) {
        DbUtils.closeQuietly(stmt);
    }

    public static void close(ResultSet rs) {
        DbUtils.closeQuietly(rs);
    }

    public static void executeUpdate(Connection conn, String sql) {
        QueryRunner qr = new QueryRunner();
        try {
            qr.update(conn, sql);
        } catch (SQLException e) {
            logger.error("Error on execute sql: " + sql, e);
        }
    }

    public static void executeUpdate(Connection conn, String sql, Object... params) {
        QueryRunner qr = new QueryRunner();
        try {
            qr.update(conn, sql, params);
        } catch (SQLException e) {
            logger.error("Error on execute sql: " + sql, e);
        }
    }

    public static ArrayList<Object[]> executeQuery(Connection conn, String sql) {
        QueryRunner qr = new QueryRunner();
        ArrayListHandler rsh = new ArrayListHandler();
        ArrayList<Object[]> rows = null;
        try {
            rows = (ArrayList<Object[]>)qr.query(conn, sql, rsh);
        } catch (SQLException e) {
            logger.error("Error on execute sql: " + sql, e);
        }
        return rows;
    }

    public static ArrayList<Object[]> executeQuery(Connection conn, String sql, Object... params) {
        QueryRunner qr = new QueryRunner();
        ArrayListHandler rsh = new ArrayListHandler();
        ArrayList<Object[]> rows = null;
        try {
            rows = (ArrayList<Object[]>)qr.query(conn, sql, rsh, params);
        } catch (SQLException e) {
            logger.error("Error on execute sql: " + sql, e);
        }
        return rows;
    }
}
