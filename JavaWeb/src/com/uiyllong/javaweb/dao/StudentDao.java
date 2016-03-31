package com.uiyllong.javaweb.dao;


import com.uiyllong.javaweb.javaBean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YLL on 2016/3/10.
 */
public class StudentDao {

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String driverClass = "com.mysql.jdbc.Driver";                      //数据库驱动
            String url = "jdbc:mysql://localhost:3306/scoredb";                //数据库scoredb
            String user = "root";
            String password = "06dmysql";
            connection = DriverManager.getConnection(url, user, password);
            String sql = "SELECT studentNo, studentName, sex, birthday, native, nation, classNo from student";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String studentNo = resultSet.getString(1);
                String studentName = resultSet.getString(2);
                String sex = resultSet.getString(3);
                String birthday = resultSet.getString(4);
                String nativ =resultSet.getString(5);
                String nation = resultSet.getString(6);
                String classno = resultSet.getString(7);
                Student student = new Student(studentNo, studentName, sex, birthday, nativ, nation, classno);
                students.add(student);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(resultSet !=null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return students;
    }
}
