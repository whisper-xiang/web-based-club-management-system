<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>活动报名查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	<link rel="stylesheet" href="images/bootstrap.min.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">活动报名列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="huodongbaomingList.do" name="myform" method="post">
									查询   用户名：<input name="yonghuming" type="text" id="yonghuming" class="form-control2" />  姓名：<input name="xingming" type="text" id="xingming" class="form-control2" />  社团名称：<input name="shetuanmingcheng" type="text" id="shetuanmingcheng" class="form-control2" />  社团类型：<input name="shetuanleixing" type="text" id="shetuanleixing" class="form-control2" />  活动主题：<input name="huodongzhuti" type="text" id="huodongzhuti" class="form-control2" />  活动地点：<input name="huodongdidian" type="text" id="huodongdidian" class="form-control2" />  活动时间：<input name="huodongshijian" type="text" id="huodongshijian" class="form-control2" />  报名人：<input name="baomingren" type="text" id="baomingren" class="form-control2" />
									<input type="submit" value="查询" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bordercolor="#F3F3F3" bgcolor="#ebf0f7" class="table table-striped table-bordered table-hover">
                          <tr>
                            <td width="30px" height="50" align="center" bgcolor="#ebf0f7">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>用户名</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td align='center' bgcolor='#ebf0f7'>社团名称</td>    <td align='center' bgcolor='#ebf0f7'>社团类型</td>    <td align='center' bgcolor='#ebf0f7'>活动主题</td>    <td align='center' bgcolor='#ebf0f7'>活动地点</td>    <td align='center' bgcolor='#ebf0f7'>活动时间</td>    <td align='center' bgcolor='#ebf0f7'>报名人</td>    <td align='center' bgcolor='#ebf0f7'>报名理由</td>    <td  width='80' align='center' bgcolor='#ebf0f7'>是否审核</td>
                            <td width="150px" height="50" align="center" bgcolor="#ebf0f7"> 添加时间 </td>
                            <td width="150px" height="50" align="center" bgcolor="#ebf0f7"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center">
                              <td height="50" align="center"><%=i%></td>
                             <td>${u.yonghuming}</td>    <td>${u.xingming}</td>    <td>${u.shetuanmingcheng}</td>    <td>${u.shetuanleixing}</td>    <td>${u.huodongzhuti}</td>    <td>${u.huodongdidian}</td>    <td>${u.huodongshijian}</td>    <td>${u.baomingren}</td>    <td>${u.baomingliyou}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=huodongbaoming'"/></td>
                              <td height="50" align="center"> ${u.addtime } </td>
                              <td height="50" align="center"> <!--lianjie1--> <a class="btn btn-info btn-small" href="huodongbaomingDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="huodongbaomingList.do?page=1" >首页</a>
             <a href="huodongbaomingList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="huodongbaomingList.do?page=${page.page+1 }">下一页</a>
			<a href="huodongbaomingList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>

