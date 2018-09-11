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
<meta charset="utf-8">
<title>注册界面</title>
<link rel="stylesheet" href="<%=path%>/css/reset.css" />
<link rel="stylesheet" href="<%=path%>/css/common.css" />
<link rel="stylesheet" href="<%=path%>/css/font-awesome.min.css" />

<script type="text/javascript">
function   createXmlHttpRequest(){
	   var httpReq ;
	   try{    //Firefox, Opera 8.0+, Safari…
	 		httpReq=new XMLHttpRequest();
	    }catch (e){
	            try{    //Internet Explorer
	 		      httpReq =new ActiveXObject("Msxml2.XMLHTTP");
	            }catch (e){
	                  try{
	 			 httpReq=new ActiveXObject("Microsoft.XMLHTTP");
	                  }catch (e){}  
	           }
	    }
	   return httpReq ; 
}

//初始化XmlHttpRequest对象
var httpReq = createXmlHttpRequest();	
function usernameValidate(){
	var username = document.f1.username.value;
	httpReq.open("post", "<%=path%>/servlet/UsersServlet?action=validate", "true");
	httpReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	httpReq.onreadystatechange=processResponse;
	httpReq.send("action=validate&username="+username);

}
function   processResponse() {// 处理返回信息的函数
	if(httpReq.readyState==4){
		if(httpReq.status==200){
			if(httpReq.responseText=="用户名已存在"){
			alert("用户名已存在");
			document.f1.username.value="";
			}
		}
	}
}

</script>

<script type="text/javascript">
		function checkForm(){
			var flag=true;
			if(!checkPassword2()) flag=false;
			return flag;
		}
		
		function checkPassword2(){
			if(f1.password.value==f1.password2.value){
				return true;
			}else{
				alert("两次密码输入不一致，请重新输入！");
				f1.password.value="";
				f1.password2.value="";
				return false;
			}
		}
</script>
</head>

<body>
	<div class="wrap login_wrap">
		<div class="content">

			<div class="logo"></div>

			<div class="login_box">

				<div class="login_form">
					<div class="login_title">注册</div>
					<form name="f1"
						action="<%=path%>/servlet/UsersServlet?action=register"
						method="post" onSubmit="return checkForm()">

						<div class="form_text_ipt">
							<input name="username" type="text" placeholder="账号" minlength="6"
								maxlength="11" onblur="usernameValidate()" required>
						</div>
						<div class="ececk_warning"></div>
						<div class="form_text_ipt">
							<input name="password" type="password" placeholder="密码" required>
						</div>
						<div class="ececk_warning"></div>
						<div class="form_text_ipt">
							<input name="password2" type="password" onBlur="checkPassword2()"
								placeholder="重复密码" required>
						</div>
						<div class="ececk_warning"></div>

						<div class="ececk_warning"></div>

						<div class="form_btn">
							<button type="submit" value="注册">注册</button>
						</div>
						<div class="form_reg_btn">
							<span>已有帐号？</span> <a href="<%=path%>/users/login.jsp">马上登录</a>
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
   alert("注册失败!");
  }
  <%session.setAttribute("error", "no");%>
</script>