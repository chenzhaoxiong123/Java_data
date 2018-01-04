<%@ page import="com.lanou3g.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/2
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>主页</title>
  <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>

  <%
    if(session.getAttribute("user")!=null){
      User user = (User) session.getAttribute("user");
      session.setAttribute("username",user.getUsername());
      session.setAttribute("password",user.getPassword());
      %>
      <table id="b" border="1"></table>
      <%
    }else {
        out.write("请登录");
  %>
        <a href="http://localhost:8080/register.html">注册</a>
  <%
  %>
        <a href="http://localhost:8080/login.jsp">登录</a>
  <%
    }
  %>

  <%
    if (session.getAttribute("username")!=null){
  %>
    用户名:<%=session.getAttribute("username")%><br/>
    密码:<%=session.getAttribute("password")%><br/>

    <a href="login.jsp">退出</a>


  <%
    }else {
  %>
    <%request.getRequestDispatcher("/login.html");%>
  <%
    }
  %>
<%--<h1>用户名：<span id="username"></span></h1>--%>
<%--<h1>密码：<span id="password"></span></h1>--%>

</body>
<script type="text/javascript">
//    $.getJSON("http://localhost:8080/show",
//        function (json,status) {
//            if(status == "success"){
//                $('#username').text(json['username']);
//                $('#password').text(json['password']);
//            }
//        })
$.getJSON("http://localhost:8080/book",function (json,status) {
    console.log(status);
    if (status == "success"){
        $('#b').append(
            $('<tr>').append(
                $('<th>').text("书名")
            ).append(
                $('<th>').text("作者")
            ).append(
                $('<th>').text("价钱")
            )
        );
        $.each(json,function (index, obj) {
            var bkname = obj['bkname'];
            var author = obj['author'];
            var price = obj['price'];
            $('#b').append(
                $('<tr>')
                    .append(
                        $('<td>').text(bkname)
                    ).append(
                    $('<td>').text(author)
                ).append(
                    $('<td>').text(price)
                )
            )
        })
    }

})
</script>
</html>
