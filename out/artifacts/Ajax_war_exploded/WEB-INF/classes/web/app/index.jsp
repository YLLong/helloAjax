<%--
  Created by IntelliJ IDEA.
  User: YLL
  Date: 2016/2/2
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Ajax 典型应用 添加商品</title>

  <!--
  1、获取当前页面的所有 a 节点，并为每个节点都添加 onclick 响应函数，同时取消其默认行为
  2、准备发送 Ajax 请求： url(a 节点的 href 属性值)；args(时间戳)
  3、响应为一个 JSON 对象，包括：bookName,totalBookNum,totalMoney
  4、把对应的属性添加到对应的位置
  -->

  <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
  <script type="text/javascript">
      $(function () {
          var isHaveCart = "${sessionScope.sc == null}";
          if(isHaveCart == "true") {
              $("#carts").hide();
          }else {
              $("#carts").show();
              $("#bookName").text("${sessionScope.sc.bookName}");
              $("#totalBookNum").text("${sessionScope.sc.totalBookNum}");
              $("#totalMoney").text("${sessionScope.sc.totalMoney}");
          }
          $("a").click(function () {
              $("#carts").show();
              var url = this.href;
              var args = {"time":new Date()}
              $.getJSON(url, args, function (date) {
                  $("#bookName").text(date.bookName);
                  $("#totalBookNum").text(date.totalBookNum);
                  $("#totalMoney").text(date.totalMoney);
              });
              return false;
          });
      });
  </script>
</head>
<body>

<div id="carts">
    你已经 &nbsp;<span id="bookName"></span> &nbsp; 加入到购物车中.
    购物车中共有 &nbsp;<span id="totalBookNum"></span> &nbsp; 本书，
    总价格 &nbsp;<span id="totalMoney"></span> &nbsp; 钱.
</div>
<br><br>

JAVA &nbsp; <a href="${pageContext.request.contextPath}/addToCart?id=java&price=100">加入购物车</a>
<br><br>

HTML &nbsp; <a href="${pageContext.request.contextPath}/addToCart?id=html&price=200">加入购物车</a>
<br><br>

AJAX &nbsp; <a href="${pageContext.request.contextPath}/addToCart?id=ajax&price=50">加入购物车</a>
<br><br>

JSP &nbsp; <a href="${pageContext.request.contextPath}/addToCart?id=jsp&price=150">加入购物车</a>
<br><br>

</body>
</html>
