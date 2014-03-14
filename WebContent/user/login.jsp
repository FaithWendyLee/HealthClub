<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="nav.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>	
<script type="text/javascript">
	$(function  () {
		
	});
</script>
<title>用户登录</title>
</head>
<body>
	<form class="form-horizontal" action="Login.action" method="post">
		<div class="control-group">
	    <label class="control-label">卡号</label>
	    <div class="controls">
	      <input type="text" name="card.id" placeholder="请输入卡号">
	    </div>
	  </div>
	  	<div class="control-group">
	    <label class="control-label">密码</label>
	    <div class="controls">
	      <input type="password" name="card.password" placeholder="请输入会员卡的密码">
	    </div>
	  </div>
	  <div class="control-group" id="buttons">
	    <div class="controls">
	      <button type="submit" class="btn inline">登录</button>
	      <a class="btn inline" href="register.jsp">注册</a>
	    </div>
	  </div>
	</form>
</body>
</html>