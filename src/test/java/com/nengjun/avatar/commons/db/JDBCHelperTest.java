package com.nengjun.avatar.commons.db;

import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Henry on 16/8/6.
 */
public class JDBCHelperTest {
    @Test
    public void test() {
        String sql = "select Id, Name, Number, ClassId from Student";
        Connection connection = DBConnectionManager.getConnection();
        ArrayList<Object[]> rows = JDBCHelper.executeQuery(connection, sql);
        for (Object[] row : rows) {
            System.out.println(row[1]);
        }
        JDBCHelper.close(connection);
    }
}
