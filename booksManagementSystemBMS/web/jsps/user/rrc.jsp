<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/9
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="../../regist" method="post">
        注册码:<input type="text" name="uid">
        <a href="<c:url value='/jsps/user/login.jsp'/>"><input type="submit"></a>
    </form>
</body>
</html>
