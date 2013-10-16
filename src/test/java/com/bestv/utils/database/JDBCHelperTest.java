package com.bestv.utils.database;

import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;

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
        Connection connection = DBConnectionManager.getConnection();
        ArrayList<Object[]> rows = JDBCHelper.executeQuery(connection, sql);
        for (Object[] row : rows) {
            System.out.println(row[1]);
        }
        JDBCHelper.close(connection);
    }
}
