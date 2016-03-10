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
        //1����ȡ���������id��price
        String bookName = request.getParameter("id");
        int price = Integer.parseInt(request.getParameter("price"));

        //2����ȡ���ﳵ����
        HttpSession session = request.getSession();
        ShoppingCart sc = (ShoppingCart)session.getAttribute("sc");
        if( sc == null) {
            sc = new ShoppingCart();
            session.setAttribute("sc", sc);
        }
        //3���ѵ����ѡ����뵽���ﳵ��
        sc.addToCart(bookName, price);
        //4��׼����Ӧ JSON ����:{"bookName":"","totalBookNum":"","totalMoney":""}
        //**��ӷ���˷��� JSON �ַ�����������������ʹ��˫����
        StringBuilder result = new StringBuilder();
        result.append("{")
                .append("\"bookName\":\"" + bookName + "\",")
                .append("\"totalBookNum\":" + sc.getTotalBookNum())
                .append(",")
                .append("\"totalMoney\":" + sc.getTotalMoney())
                .append("}");
        //5����Ӧ JSON ����
        response.setContentType("text/javascript");
        response.getWriter().print(result.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
