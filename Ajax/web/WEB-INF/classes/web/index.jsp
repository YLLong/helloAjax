<%--
  Created by IntelliJ IDEA.
  User: YLL
  Date: 2016/1/24
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title> Hello Ajax </title>
    <script type="text/javascript">
      window.onload = function () {
        //1、获取 a 节点，并为其添加 onclick 响应函数
        document.getElementsByTagName("a")[0].onclick = function () {
          //3、创建一个 XMLHttpRequest 对象
          var request = null;
          request = new XMLHttpRequest();
          //4、准备发送请求的数据：url
          var url = this.href;
          var method = "GET";
          //5、调用 XMLHttpRequest 对象的 open 方法
          request.open(method, url);
          //6、调用 XMLHttpRequest 对象的 send 方法
          request.send(null);
          //7、为 XMLHttpRequest 对象添加 onreadystatechange 响应函数
          request.onreadystatechange = function () {
            //8、判断响应是否完成：XMLHttpRequest 对象的 readyState 的属性值为4的时候
            if(request.readyState == 4) {
              //9、再判断响应是否可用：XMLHttpRequest 对象 status 的属性值为200
              if(request.status == 200 || request.status == 304) {
                //10、打印响应结果：responseText
                alert(request.responseText);
              }
            }
          }
          //2、取消 a 节点的默认行为
          return false;
        }
      }
    </script>
  </head>
  <body>
  <a href="HelloAjax.txt">Hello Ajax</a>
  </body>
</html>