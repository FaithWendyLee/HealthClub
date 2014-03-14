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
			$("button#addUserBtn").hide()
		});
		function addUser(){
			var o = $("#main").clone(true);
			o.attr("id", "notmain");
			o.insertBefore($("#buttons"));
		}
		function resetUser(){
			$(".user").not("#main").remove();	
		}
	</script>
	<title>用户注册</title>
</head>
<body>
	<form class="form-horizontal" action="Register.action" method="post">
	<div class="card">
		<div class="control-group">
	    <label class="control-label">银行账户</label>
	    <div class="controls">
	      <input type="text" name="card.bankaccount" placeholder="请输入银行账户">
	    </div>
	  </div>
	  	<div class="control-group">
	    <label class="control-label">密码</label>
	    <div class="controls">
	      <input type="password" name="card.password" placeholder="请输入会员卡的密码">
	    </div>
	  </div>
	  	<div id="type" class="control-group">
	    <label class="control-label">类型</label>
	    <div class="controls">
			<label class="radio">
			<input type="radio" name="type" id="normal" value="normal" checked onclick="$('#addUserBtn').hide();resetUser()">
			  普通
			</label>
			<label class="radio">
			  <input type="radio" name="type" id="family" value="family" onclick="
			  $('#addUserBtn').show();addUser()">
			  家庭
			</label>
	    </div>
	  </div>
	</div>
	<div class="user" id="main">
	<!-- 用户名 -->
	<div class="control-group">
	    <label class="control-label">用户名</label>
	    <div class="controls">
	      <input type="text" name="name" placeholder="请输入用户名">
	    </div>
	  </div>
	  	  <div class="control-group">
	    <label class="control-label">性别</label>
	    <div class="controls">
		<select name = "sex">
		  <option>男</option>
		  <option>女</option>
		</select>
		</div>
	  </div>
	  <div class="control-group">
	    <label class="control-label">地址</label>
	    <div class="controls">
	      <input type="text" name="address" placeholder="请输入地址">
	    </div>
	  </div>
	 <div class="control-group">
	    <label class="control-label">年龄</label>
	    <div class="controls">
	      <input type="text" name="age" placeholder="请输入年龄">
	    </div>
	  </div>
	</div>
	<!-- 按钮 -->

	  <div class="control-group" id="buttons">
	    <div class="controls">
	      <button id="addUserBtn" type="button" class="btn inline" onclick="addUser()">增加用户</button>
	      <button type="submit" class="btn inline">提交</button>
	    </div>
	  </div>
	</form>
</body>
</html>