<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>社团活动详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  社团活动详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>用户名：</td><td width='39%'>${shetuanhuodong.yonghuming}</td><td  rowspan=7 align=center><a href=${shetuanhuodong.haibao} target=_blank><img src=${shetuanhuodong.haibao} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>姓名：</td><td width='39%'>${shetuanhuodong.xingming}</td></tr><tr><td width='11%' height=44>社团名称：</td><td width='39%'>${shetuanhuodong.shetuanmingcheng}</td></tr><tr><td width='11%' height=44>社团类型：</td><td width='39%'>${shetuanhuodong.shetuanleixing}</td></tr><tr><td width='11%' height=44>活动主题：</td><td width='39%'>${shetuanhuodong.huodongzhuti}</td></tr><tr><td width='11%' height=44>活动地点：</td><td width='39%'>${shetuanhuodong.huodongdidian}</td></tr><tr><td width='11%' height=44>活动时间：</td><td width='39%'>${shetuanhuodong.huodongshijian}</td></tr><tr><td width='11%' height=100  >简介：</td><td width='39%' colspan=2 height=100 >${shetuanhuodong.jianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

