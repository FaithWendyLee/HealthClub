<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>登录</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
	<form class="form-horizontal" action="EmployeeLogin.action" method="post">
		<div class="control-group">
	    <label class="control-label">ID</label>
	    <div class="controls">
	      <input type="text" name="employee.id" placeholder="请输入卡号">
	    </div>
	  </div>
	  	<div class="control-group">
	    <label class="control-label">密码</label>
	    <div class="controls">
	      <input type="password" name="employee.password" placeholder="请输入会员卡的密码">
	    </div>
	  </div>
	  <input type="hidden" name="type" value="staff">
	  <div class="control-group" id="buttons">
	    <div class="controls">
	      <button type="submit" class="btn">登录</button>
	    </div>
	  </div>
	</form>
    <script src="../js/jquery.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <jsp:include page="../footer.jsp" />
</body>
</html>