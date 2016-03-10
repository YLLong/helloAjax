package com.uiyllong.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YLL on 2016/2/3.
 */
public class loginServlet implements Servlet {
    private ServletConfig servletConfig;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //1、获取请求参数：username，password
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        //2、获取当前 WEB 应用的初始化参数：user，password
        //需要使用 ServletContext 对象
        ServletContext servletContext = servletConfig.getServletContext();
        String username1 = servletContext.getInitParameter("username");
        String password1 = servletContext.getInitParameter("password");
        //3、对比
        PrintWriter out = servletResponse.getWriter();
        if(username.equals(username1) && password.equals(password1)) {
            //4、打印响应的字符串
            out.println("请求成功！" + username + ";" + password);
        }else {
            out.println("请求失败！" + username);
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
