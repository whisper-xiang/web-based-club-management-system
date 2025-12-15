<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="code" scope="page" class="com.util.CheckCode" />
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>大学生社团管理系统</title>
<link href="images/css/bootstrap.min.css" rel="stylesheet">
<link href="images/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="images/css/zzsc.css">
</head>
<script type="text/javascript">
	function hsgchecklogin() {
	if(document.f11.username.value=="" || document.f11.pwd.value=="" || document.f11.pagerandom.value=="")
	{
		alert("请输入完整");
		return false;
	}
	if (document.f11.pagerandom.value != document.f11.yzm.value) {
			alert("验证码错误！");
			document.f11.pagerandom.focus();
			return false;
	}
	
	}
	</script> 
<body>
<div class="demo form-bg">
	<div class="container">
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
			 <form name="f11" class="form-horizontal" method="post" action="hsgloginyanzheng.jsp" >
					<span class="heading">大学生社团管理系统</span>
					<div class="form-group">
						<input type="text" class="form-control" name="username"  id="username" placeholder="账户">
						<i class="fa fa-user"></i>					</div>
					<div class="form-group help">
						<input type="password" class="form-control" name="pwd" id="pwd" placeholder="密码">
						<i class="fa fa-lock"></i>					</div>
					<div class="form-group">
						<select name="cx" id="cx" class="form-control">
            <option value="管理员">管理员</option>


            </select>
						<i class="fa fa-film"></i>					</div>
					<div class="form-group">
						<input type="text" class="form-control"  name="pagerandom" id="pagerandom"    placeholder="验证码" style="width:200px; float:left">
						<i class="fa fa-adjust"></i>		<%
								String yzm=code.getCheckCode();
								%>  <input type="hidden" name="yzm" value="<%=yzm %>" >
								   <%=yzm %>	</div>
					<div class="form-group">
						
						<button type="submit" class="btn btn-default" onClick="return hsgchecklogin();">立刻登录</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>