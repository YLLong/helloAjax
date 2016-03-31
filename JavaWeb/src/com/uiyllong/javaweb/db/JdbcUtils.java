package com.uiyllong.javaweb.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC �����Ĺ�����
 * Created by YLL on 2016/3/11.
 */
public class JdbcUtils {

    /**
     * �ͷ� connection ����
     *
     * @param connection
     */
    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static DataSource dataSource = null;

    static {
        //����Դֻ�ܱ�����һ��
        dataSource = new ComboPooledDataSource("javaweb");
    }

    /**
     * ��������Դ��һ�� connection ����
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {

            return dataSource.getConnection();

    }

}
