package com.uiyllong.javaweb.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC 操作的工具类
 * Created by YLL on 2016/3/11.
 */
public class JdbcUtils {

    /**
     * 释放 connection 连接
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
        //数据源只能被创建一次
        dataSource = new ComboPooledDataSource("javaweb");
    }

    /**
     * 返回数据源的一个 connection 对象
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {

            return dataSource.getConnection();

    }

}
