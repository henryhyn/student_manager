package com.bestv.utils.database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 13-10-17
 * Time: 上午12:25
 * To change this template use File | Settings | File Templates.
 */
public class JDBCHelperTest {
    @Test
    public void test() {
        String sql = "select id, name, number, class_id from student";
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = DBConnectionManager.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
