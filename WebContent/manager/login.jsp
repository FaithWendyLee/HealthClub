<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="nav.jsp"/>
<jsp:include page="../staff/login.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>登录</title>
<script type="text/javascript">
	$(function  () {
		$("input[type='hidden']").attr("value", "manager");
	});
</script>
</head>
<body>

    <script src="../js/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>