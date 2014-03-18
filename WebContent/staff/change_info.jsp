<%@page import="model.Card"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	List<Card> cards = (List<Card>) session.getAttribute("cards");
 	int index = Integer.parseInt(request.getParameter("index"));
 	session.setAttribute("p_card", cards.get(index));
 	session.setAttribute("p_users", new ArrayList<User>(cards.get(index).getUsers()));
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		changeNavTo("show_cards");
	});
</script>
<title></title>
</head>
<body>
	<div id="main">
		<jsp:include page="nav.jsp" />
		<div id="site_content">
			<div id="left_content">
				<form class="form-horizontal" action="ChangeInfo.action" method="post">
					<div class="card">
						<div class="control-group">
							<label class="control-label">银行账户</label>
							<div class="controls">
								<input type="text" name="card.bankaccount" placeholder="请输入银行账户" 
								value=<s:property value="#session.p_card.bankaccount"/>>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">密码</label>
							<div class="controls">
								<input type="password" name="card.password"
									placeholder="请输入会员卡的密码" value=<s:property value="#session.p_card.password"/>>
							</div>
						</div>
					</div>
					<s:iterator value="#session.p_users">
						<div class="user" >
							<!-- 用户名 -->
							<div class="control-group">
								<label class="control-label">用户名</label>
								<div class="controls">
									<input type="text" name="name" placeholder="请输入用户名" value=<s:property value="name"/>>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">性别</label>
								<div class="controls">
									<select name="sex">
										<s:if test="sex.toString() == 'MALE'">
											<option id="MALE" selected>男</option>
											<option id="FEMALE">女</option>
										</s:if>
										<s:else>
											<option id="MALE">男</option>
											<option id="FEMALE" selected>女</option>
										</s:else>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">地址</label>
								<div class="controls">
									<input type="text" name="address" placeholder="请输入地址" value=<s:property value="address"/>>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">年龄</label>
								<div class="controls">
									<input type="text" name="age" placeholder="请输入年龄" value=<s:property value="age"/>>
								</div>
							</div>
						</div>
						<input type="hidden" name="source" value="staff">
					</s:iterator>
					<!-- 按钮 -->

					<div class="control-group" id="buttons">
						<div class="controls">
							<button type="submit" class="btn inline">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>