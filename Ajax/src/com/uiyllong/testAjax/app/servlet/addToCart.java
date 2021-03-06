package com.uiyllong.testAjax.app.servlet;

import com.uiyllong.testAjax.app.beans.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by YLL on 2016/2/2.
 */
@WebServlet(name = "addToCart")
public class addToCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数：id，price
        String bookName = request.getParameter("id");
        int price = Integer.parseInt(request.getParameter("price"));

        //2、获取购物车对象
        HttpSession session = request.getSession();
        ShoppingCart sc = (ShoppingCart)session.getAttribute("sc");
        if( sc == null) {
            sc = new ShoppingCart();
            session.setAttribute("sc", sc);
        }
        //3、把点击的选项加入到购物车中
        sc.addToCart(bookName, price);
        //4、准备响应 JSON 对象:{"bookName":"","totalBookNum":"","totalMoney":""}
        //**如从服务端返回 JSON 字符串，则属性名必须使用双引号
        StringBuilder result = new StringBuilder();
        result.append("{")
                .append("\"bookName\":\"" + bookName + "\",")
                .append("\"totalBookNum\":" + sc.getTotalBookNum())
                .append(",")
                .append("\"totalMoney\":" + sc.getTotalMoney())
                .append("}");
        //5、响应 JSON 对象
        response.setContentType("text/javascript");
        response.getWriter().print(result.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
