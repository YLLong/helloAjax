package com.uiyllong.javaweb.servlet;

import com.uiyllong.javaweb.dao.StudentDao;
import com.uiyllong.javaweb.javaBean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by YLL on 2016/3/10.
 */
@WebServlet(name = "ListAllStudents")
public class ListAllStudents extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("students", Arrays.asList("AA", "BB", "CC"));
//        request.getRequestDispatcher("/students.jsp").forward(request, response);
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.getAll();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/students.jsp").forward(request, response);
    }
}
