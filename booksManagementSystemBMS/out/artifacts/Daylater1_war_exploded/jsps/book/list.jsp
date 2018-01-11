<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>
  </head>
  
  <body>

<c:forEach items="${requestScope.book}" var="all" step="1">
    <div class="icon">
        <a href="<c:url value='/book?method=particular&bid=${all.bid}'/>"><img src="<c:url value='${all.image}'/>" border="0"/></a>
        <br/>
        <a href="<c:url value='/book?method=particular&bid=${all.bid}'/>">${all.bname}</a>
    </div>
</c:forEach>

  <c:forEach items="${requestScope.se}" var="sebooks" step="1">
      <div class="icon">
          <a href="<c:url value='/book?method=particular&bid=${sebooks.bid}'/>"><img src="<c:url value='${sebooks.image}'/>" border="0"/></a>
          <br/>
          <a href="<c:url value='/book?method=particular&bid=${sebooks.bid}'/>">${sebooks.bname}</a>
      </div>
  </c:forEach>

<c:forEach items="${requestScope.ee}" var="eebooks" step="1">
    <div class="icon">
        <a href="<c:url value='/book?method=particular&bid=${eebooks.bid}'/>"><img src="<c:url value='${eebooks.image}'/>" border="0"/></a>
        <br/>
        <a href="<c:url value='/book?method=particular&bid=${eebooks.bid}'/>">${eebooks.bname}</a>
    </div>
</c:forEach>

<c:forEach items="${requestScope.js}" var="jsbooks" step="1">
    <div class="icon">
        <a href="<c:url value='/book?method=particular&bid=${jsbooks.bid}'/>"><img src="<c:url value='${jsbooks.image}'/>" border="0"/></a>
        <br/>
        <a href="<c:url value='/book?method=particular&bid=${jsbooks.bid}'/>">${jsbooks.bname}</a>
    </div>
</c:forEach>
  </body>

</html>

