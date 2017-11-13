<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
	  <table>
	  	<tr>
	  		<td>编号</td>
	  		<td>姓名</td>
	  	</tr>
	  	
	  	<c:forEach items="${sessionScope.hiberlist}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td><a href="findById?id=${item.id}">修改</a></td>
			</tr>
	  	</c:forEach>
	  </table>
	<a href="getAll?pageindex=1">首页</a>
	<A href="getAll?pageindex=${pageindex-1}">上一页</A>
	<form action="getAll" method="post">
		<input type="text" name="pageindex" size="1"> <input type="submit" value="跳页"/>
	</form>
	<a href="getAll?pageindex=${pageindex+1}">下一页</a>
	<a href="getAll?pageindex=${countpage}">末页</a>
  </body>
</html>
