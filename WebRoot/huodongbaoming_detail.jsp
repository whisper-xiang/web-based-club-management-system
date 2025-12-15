<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>活动报名详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  活动报名详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>用户名：</td><td width='39%'>${huodongbaoming.yonghuming}</td>     <td width='11%'>姓名：</td><td width='39%'>${huodongbaoming.xingming}</td></tr><tr>     <td width='11%'>社团名称：</td><td width='39%'>${huodongbaoming.shetuanmingcheng}</td>     <td width='11%'>社团类型：</td><td width='39%'>${huodongbaoming.shetuanleixing}</td></tr><tr>     <td width='11%'>活动主题：</td><td width='39%'>${huodongbaoming.huodongzhuti}</td>     <td width='11%'>活动地点：</td><td width='39%'>${huodongbaoming.huodongdidian}</td></tr><tr>     <td width='11%'>活动时间：</td><td width='39%'>${huodongbaoming.huodongshijian}</td>     <td width='11%'>报名人：</td><td width='39%'>${huodongbaoming.baomingren}</td></tr><tr>     <td width='11%'>报名理由：</td><td width='39%'>${huodongbaoming.baomingliyou}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

