<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="nav.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/jquery.js"></script>
<title>错误</title>
</head>
<body>
<div id="main">
	<jsp:include page="nav.jsp"/>
	<div id="site_content">
	<h1><%= session.getAttribute("error") %></h1>
	<a href="login.jsp" class="btn">返回登录</a>
	</div>
	</div>
</body>
</html>