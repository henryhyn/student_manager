package com.nengjun.avatar.commons.db;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Henry on 16/8/6.
 */
@Slf4j
public class JDBCHelper {
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

    public static ArrayList<Object> executeQuery(Connection conn, String sql, Class<?> objectType) {
        QueryRunner qr = new QueryRunner();
        ObjectListHandler rsh = new ObjectListHandler(objectType);
        ArrayList<Object> rs = null;
        try {
            rs = (ArrayList<Object>) qr.query(conn, sql, rsh);
        } catch (SQLException e) {
            log.error("Error on execute sql: " + sql, e);
        }
        return rs;
    }

    public static ArrayList<Object> executeQuery(Connection conn, String sql, Class<?> objectType, Object... params) {
        QueryRunner qr = new QueryRunner();
        ObjectListHandler rsh = new ObjectListHandler(objectType);
        ArrayList<Object> rs = null;
        try {
            rs = (ArrayList<Object>) qr.query(conn, sql, rsh, params);
        } catch (SQLException e) {
            log.error("Error on execute sql: " + sql, e);
        }
        return rs;
    }

    public static ArrayList<Object[]> executeQuery(Connection conn, String sql) {
        QueryRunner qr = new QueryRunner();
        ArrayListHandler rsh = new ArrayListHandler();
        ArrayList<Object[]> rs = null;
        try {
            rs = (ArrayList<Object[]>) qr.query(conn, sql, rsh);
        } catch (SQLException e) {
            log.error("Error on execute sql: " + sql, e);
        }
        return rs;
    }

    public static ArrayList<Object[]> executeQuery(Connection conn, String sql, Object... params) {
        QueryRunner qr = new QueryRunner();
        ArrayListHandler rsh = new ArrayListHandler();
        ArrayList<Object[]> rs = null;
        try {
            rs = (ArrayList<Object[]>) qr.query(conn, sql, rsh, params);
        } catch (SQLException e) {
            log.error("Error on execute sql: " + sql, e);
        }
        return rs;
    }

    public static void executeUpdate(Connection conn, String sql) {
        QueryRunner qr = new QueryRunner();
        try {
            qr.update(conn, sql);
        } catch (SQLException e) {
            log.error("Error on execute sql: " + sql, e);
        }
    }

    public static void executeUpdate(Connection conn, String sql, Object... params) {
        QueryRunner qr = new QueryRunner();
        try {
            qr.update(conn, sql, params);
        } catch (SQLException e) {
            log.error("Error on execute sql: " + sql, e);
        }
    }

    public static int[] executeBatch(Connection conn, String sql) {
        QueryRunner qr = new QueryRunner();
        int[] rs = null;
        try {
            rs = qr.batch(conn, sql, new Object[0][0]);
        } catch (SQLException e) {
            log.error("Error on execute sql: " + sql, e);
        }
        return rs;
    }

    public static int[] executeBatch(Connection conn, String sql, Object[][] params) {
        QueryRunner qr = new QueryRunner();
        int[] rs = null;
        try {
            rs = qr.batch(conn, sql, params);
        } catch (SQLException e) {
            log.error("Error on execute sql: " + sql, e);
        }
        return rs;
    }
}
