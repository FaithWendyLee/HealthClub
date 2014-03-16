<%@page import="model.type.StatusType"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.type.SexType"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.type.CardType"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="p_card" class="model.Card" scope="session"/>
<% List<User> users = (List<User>) session.getAttribute("p_users");%>
<jsp:setProperty name="p_card" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/jquery.js"></script>
<script type="text/javascript">
	
	$(function () {
		changeNavTo("change_info");
		$("input[name='card.bankaccount']").attr("value", <%=p_card.getBankaccount() %>);
		$("input[name='card.password']").attr("value", "<%=p_card.getPassword() %>");
		$("#type").remove();
		<% for( int i = 1; i < users.size(); i++ ) {%>
			addUser();
		<%}%>
		var i = 0;
		<% for( int i = 0; i < users.size(); i++ ) {
			 User user = users.get(i); %>
			 console.log(i);
			$("input[name='name']").eq(i).attr("value", "<%=user.getName()%>");
			var sexvalue = "female";
			<% if (user.getSex()==SexType.MALE) %>
				sexvalue = "male";
			$("input[name='sex']").eq(i).val(sexvalue);
			$("input[name='address']").eq(i).attr("value", "<%=user.getAddress()%>");
			$("input[name='age']").eq(i).attr("value", "<%=user.getAge()%>");
			i++;
		<%}%>
		<% if (p_card.getStatus() == StatusType.CANCEl) {%>
			$("<div class='control-group'><div class='controls'><label class='checkbox'><input type='checkbox' name='activate' value=false>激活会员卡</label></div></div>").insertBefore("div.user#main	");
		<% } %>
		$("form").attr("action", "ChangeInfo.action");
		$('input[type="checkbox"][name="activate"]').change(function() {
		      this.value = this.checked;
		 });
	});
</script>
<title>修改个人资料</title>
</head>
<body>
<div id="main">
	<jsp:include page="nav.jsp"/>
	<div id="site_content">
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
	     	<button type="submit" class="btn inline">提交</button>
	    </div>
	  </div>
	</form>
	</div>
	</div>
</body>
</html>