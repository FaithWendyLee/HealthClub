<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="nav.jsp"/>
<jsp:useBean id="card" class="model.Card" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<title>注册成功</title>
</head>
<body>
	<div class="container-fluid">
	  <div class="row-fluid">
		<h2><strong>您的卡号：</strong><jsp:getProperty name="card" property="id"/></h2>
		<a href="login.jsp" class="btn" >返回登录</a>	
		</div>
	</div>
</body>
</html>