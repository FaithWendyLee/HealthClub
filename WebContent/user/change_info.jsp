<%@page import="model.type.StatusType"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.type.SexType"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.type.CardType"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="p_card" class="model.Card" scope="session" />
<%
	List<User> users = (List<User>) session.getAttribute("p_users");
%>
<jsp:setProperty name="p_card" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/jquery.js"></script>
<script type="text/javascript">
	
	$(function () {
		changeNavTo("change_info");
		$("input[name='card.bankaccount']").attr("value", <%=p_card.getBankaccount()%>);
		$("input[name='card.password']").attr("value", "<%=p_card.getPassword()%>");
		$("#type").remove();
		<%for( int i = 1; i < users.size(); i++ ) {%>
			addUser();
		<%}%>
		var i = 0;
		<%for( int i = 0; i < users.size(); i++ ) {
			 User user = users.get(i);%>
			 console.log(i);
			$("input[name='name']").eq(i).attr("value", "<%=user.getName()%>");
			var sexvalue = "女";
			<%if (user.getSex()==SexType.MALE) {%>
				sexvalue = "男";
			<%}%>
			$("select").eq(i).val(sexvalue);
			$("input[name='address']").eq(i).attr("value", "<%=user.getAddress()%>");
			$("input[name='age']").eq(i).attr("value", "<%=user.getAge()%>");
		i++;
<%}%>
	
<%if (p_card.getStatus() == StatusType.CANCEl) {%>
	$(
				"<div class='control-group'><div class='controls'><label class='checkbox'><input type='checkbox' name='activate' value=false>激活会员卡</label></div></div>")
				.insertBefore("div.user#main	");
<%}%>
	$("form").attr("action", "ChangeInfo.action");
		$('input[type="checkbox"][name="activate"]').change(function() {
			this.value = this.checked;
		});
	});
</script>
<title>修改个人资料</title>
</head>
<body>
<jsp:include page="register.jsp" />
</body>
</html>