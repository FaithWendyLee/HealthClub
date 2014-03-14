<%@page import="model.type.CardType"%>
<%@page import="model.type.StatusType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="nav.jsp"/>
<jsp:useBean id="p_card" class="model.Card" scope="session"/>
<jsp:setProperty name="p_card" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function () {
	changeNavTo("home");
});
</script>
<title>欢迎界面</title>
</head>
<body>
	<div class="container-fluid">
	  <div class="row-fluid">
       	<h1>欢迎您使用健身俱乐部活动预订系统</h1>
		<li><strong>您的卡号：</strong><jsp:getProperty name="p_card" property="id"/></li>
		<li><strong>您的银行账号：</strong><jsp:getProperty name="p_card" property="bankaccount"/></li>
		<li><strong>您的账号余额：</strong><jsp:getProperty name="p_card" property="remaining"/></li>
		<li><strong>您的会员卡状态：</strong><%=p_card.getStatus()==StatusType.CANCEl ? "未激活" : "激活" %></li>
		<li><strong>您的会员卡类型：</strong><%=p_card.getType()==CardType.NORMAL ? "普通" : "家庭" %></li>
		</div>
	</div>
</body>
</html>