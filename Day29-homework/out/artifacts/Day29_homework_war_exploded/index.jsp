<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/2
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>
  <button id="btn">点我</button>
  <table border="1">
    <tr>
      <th>用户名</th>
      <th>密码</th>
    </tr>
  </table>
  </body>
  <script type="text/javascript">
      $('#btn').click(function () {
          $.getJSON("http://localhost:8080/show",function (data, status) {
              if (status=="success"){
                  $.each(data,function (index, obj) {
                      var username = obj['username'];
                      var password = obj['password'];
                      console.log(username);
                      $('table').append(
                          $('<tr>').append(
                              $('<td>').text(username)
                          ).append(
                              $('<td>').text(password)
                          )
                      )
                  })
              }
          })
      })
  </script>
</html>
