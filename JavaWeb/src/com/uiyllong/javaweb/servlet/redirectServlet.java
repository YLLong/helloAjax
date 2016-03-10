package com.uiyllong.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by YLL on 2016/2/4.
 */
@WebServlet(name = "redirectServlet")
public class redirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RedirectServlet's doGet!");
        //执行请求的重定向，直接调用 response.sendRedirect（path）方法，path 为要重定向的地址
        String path = "testServlet";
        response.sendRedirect(path);

    }
}
