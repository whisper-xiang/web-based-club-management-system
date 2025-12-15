<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=huodongbaoming.xls");
%>
<html>
  <head>
    <title>活动报名</title>
  </head>

  <body >

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1">  
  <tr>
    <td width="30" align="center">序号</td>
    <td align='center'>用户名</td>    <td align='center'>姓名</td>    <td align='center'>社团名称</td>    <td align='center'>社团类型</td>    <td align='center'>活动主题</td>    <td align='center'>活动地点</td>    <td align='center'>活动时间</td>    <td align='center'>报名人</td>    <td align='center'>报名理由</td>    
	
    <td width="120" align="center" >添加时间</td>
    
  </tr>
   <%
    int i=0;
   String sql="select * from huodongbaoming  order by id desc";
ResultSet RS_result=connDbBean.executeQuery(sql);
			while(RS_result.next())
			{
				i++;
			%>
  <tr>
    <td  align="center"><%=i %></td>
    <td><%=RS_result.getString("yonghuming")%></td>    <td><%=RS_result.getString("xingming")%></td>    <td><%=RS_result.getString("shetuanmingcheng")%></td>    <td><%=RS_result.getString("shetuanleixing")%></td>    <td><%=RS_result.getString("huodongzhuti")%></td>    <td><%=RS_result.getString("huodongdidian")%></td>    <td><%=RS_result.getString("huodongshijian")%></td>    <td><%=RS_result.getString("baomingren")%></td>    <td><%=RS_result.getString("baomingliyou")%></td>    <td><%=RS_result.getString("issh")%></td>    
	
	<td><%=RS_result.getString("addtime")%></td>
   
  </tr>
  	<%
  }
   %>
   
</table>
<br>
  </body>
</html>

