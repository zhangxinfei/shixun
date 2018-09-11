<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>

<html>

<head>
<title>登录界面</title>
<link rel="stylesheet" href="<%=path%>/css/reset.css" />
<link rel="stylesheet" href="<%=path%>/css/common.css" />
<link rel="stylesheet" href="<%=path%>/css/font-awesome.min.css" />
</head>
<body>
	<div class="wrap login_wrap">
		<div class="content">
			<div class="logo"></div>
			<div class="login_box">
				<div class="login_form">
					<div class="login_title">登录</div>
					<form action="<%=path%>/servlet/UsersServlet?action=login_user"
						method="post">

						<div class="form_text_ipt">
							<input name="username" id="username" type="text" minlength="6" maxlength="11" placeholder="账号" required>
						</div>
						<div class="ececk_warning"></div>
						<div class="form_text_ipt">
							<input name="password" id="password" type="password"
								placeholder="密码" required>
						</div>
						<div class="ececk_warning"></div>
						<div class="form_btn">
							<button type="submit">登录</button>
						</div>
						<div class="form_reg_btn">
							<span>还没有帐号？</span><a href="<%=path%>/users/register.jsp">马上注册</a>
						</div>
					</form>
					<div class="other_login"></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>
</body>
</html>

<script> 
//取出传回来的参数error并与yes比较
  var error ='<%=session.getAttribute("error")%>';
  if(error=='yes'){
   alert("登录失败!");
  }
  <%session.setAttribute("error", "no");%>
</script>
 

