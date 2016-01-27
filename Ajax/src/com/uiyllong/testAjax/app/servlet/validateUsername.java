package com.uiyllong.testAjax.app.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YLL on 2016/1/27.
 */
@WebServlet(name = "validateUsername")
public class validateUsername extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> userNames = Arrays.asList("AAA", "BBB", "CCC");
        String userName = request.getParameter("userName");
        String result = null;
        if(userNames.contains(userName)) {
            result = "<font color='red'>该用户已经被使用</font>";
        }else {
            result = "<font color='green'>该用户可以使用</font>";
        }
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
