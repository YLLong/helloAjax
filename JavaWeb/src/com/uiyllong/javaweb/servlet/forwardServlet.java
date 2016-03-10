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

        //�����ת��
        //1������ HttpServletRequest �� getRequestDispatcher() ������ȡ RequestDispatcher ����
        //���� getRequestDispatcher() ��Ҫ����Ҫת���ĵ�ַ
        String path = "testServlet";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/" + path);
        //2������ HttpServletRequest �� forward��Request��response�� ���������ת��
        requestDispatcher.forward(request, response);
    }
}
