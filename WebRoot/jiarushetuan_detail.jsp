<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>加入社团详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  加入社团详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>用户名：</td><td width='39%'>${jiarushetuan.yonghuming}</td>     <td width='11%'>姓名：</td><td width='39%'>${jiarushetuan.xingming}</td></tr><tr>     <td width='11%'>社团名称：</td><td width='39%'>${jiarushetuan.shetuanmingcheng}</td>     <td width='11%'>社团类型：</td><td width='39%'>${jiarushetuan.shetuanleixing}</td></tr><tr>     <td width='11%'>申请人：</td><td width='39%'>${jiarushetuan.shenqingren}</td>     <td width='11%'>申请理由：</td><td width='39%'>${jiarushetuan.shenqingliyou}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

