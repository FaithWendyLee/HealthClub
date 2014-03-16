<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function(){
		changeNavTo("make_activity");
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
<title>Insert title here</title>
</head>
<body>
	<div id="main">
		<jsp:include page="nav.jsp" />
		<div id="site_content">
			<div id="left_content">
				<form class="form-horizontal" action="Register.action" method="post">
					<div class="card">
						<div class="control-group">
							<label class="control-label">活动地点</label>
							<div class="controls">
								<input type="text" name="activity.place" placeholder="请输入活动地点">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">教练编号</label>
							<div class="controls">
								<input type="password" name="card.coachNumber"
									placeholder="请输入教练编号	">
							</div>
						</div>
						<div id="type" class="control-group">
							<label class="control-label">时间</label>
							<div class="controls">
								<div class="input-append date form_datetime">
									<input size="16" type="text" value="" readonly> <span
										class="add-on"><i class="icon-th"></i></span>
								</div>
								<script type="text/javascript" src="../js/bootstrap-datetimepicker.js" ></script>
								<script type="text/javascript">
									$(".form_datetime").datetimepicker({
										format : "dd MM yyyy - hh:ii"
									});
								</script>

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
	</div>
</body>

</html>