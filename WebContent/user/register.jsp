<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="nav.jsp"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var o = $("#test").clone(true);
			$("form").append(o);		
		});
	</script>
	<title>用户注册界面</title>
</head>
<body>
	<form class="form-horizontal" action="Register" method="post">
	<div id="test">
	<!-- 用户名 -->
	  <div class="control-group">
	    <label class="control-label">用户名</label>
	    <div class="controls">
	      <input type="text" name="name_1" placeholder="请输入用户名">
	    </div>
	  </div>
	<!-- 按钮 -->
	  <div class="control-group">
	    <div class="controls">
	      <button type="submit" class="btn">Sign in</button>
	    </div>
	  </div>
	</div>
	</form>

</body>
</html>