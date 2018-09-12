<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page
	import="com.software.service.MessageService,com.software.domain.Message,java.text.SimpleDateFormat,java.sql.Timestamp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	This is my JSP page.
	<br>


	<% 
		MessageService messageService = new MessageService();
		
		  Date date = new Date();    //获得系统时间.
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		String nowTime = sdf.format(date);
		Date time = sdf.parse(nowTime);
		Timestamp timestamp=new Timestamp(time.getTime());
		
		Message message=new Message();
		message.setMesId(5);
		message.setHandlers("liuxuan");
		
		int pid=messageService.getParentNode("liuxuan");
		
		message.setParentNode(pid);
		message.setContents("111");
		message.setTime(timestamp);
		messageService.add(message);   
		
		//messageService.deleteMes(23, 0);
	%>
	
	
</body>
</html>
