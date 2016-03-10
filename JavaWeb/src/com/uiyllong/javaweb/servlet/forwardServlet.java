package com.uiyllong.javaweb.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by YLL on 2016/2/4.
 */
@WebServlet(name = "forwardServlet")
public class forwardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ForwardServlet's doGet!");

        //请求的转发
        //1、调用 HttpServletRequest 的 getRequestDispatcher() 方法获取 RequestDispatcher 对象
        //调用 getRequestDispatcher() 需要传入要转发的地址
        String path = "testServlet";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/" + path);
        //2、调用 HttpServletRequest 的 forward（Request，response） 进行请求的转发
        requestDispatcher.forward(request, response);
    }
}
