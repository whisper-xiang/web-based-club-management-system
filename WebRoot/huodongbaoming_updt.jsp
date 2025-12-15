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
		<TITLE>修改活动报名</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="huodongbaoming_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateHuodongbaoming.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改活动报名<input type="hidden" name="id" value="${huodongbaoming.id}" /></td>
						</tr>
						<tr ><td width="200">用户名：</td><td><input name='yonghuming' type='text' id='yonghuming' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">社团名称：</td><td><input name='shetuanmingcheng' type='text' id='shetuanmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">社团类型：</td><td><input name='shetuanleixing' type='text' id='shetuanleixing' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">活动主题：</td><td><input name='huodongzhuti' type='text' id='huodongzhuti' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">活动地点：</td><td><input name='huodongdidian' type='text' id='huodongdidian' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">活动时间：</td><td><input name='huodongshijian' type='text' id='huodongshijian' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">报名人：</td><td><input name='baomingren' type='text' id='baomingren' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		<tr ><td width="200">报名理由：</td><td><input name='baomingliyou' type='text' id='baomingliyou' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.yonghuming.value='${huodongbaoming.yonghuming}';</script>	<script language="javascript">document.form1.xingming.value='${huodongbaoming.xingming}';</script>	<script language="javascript">document.form1.shetuanmingcheng.value='${huodongbaoming.shetuanmingcheng}';</script>	<script language="javascript">document.form1.shetuanleixing.value='${huodongbaoming.shetuanleixing}';</script>	<script language="javascript">document.form1.huodongzhuti.value='${huodongbaoming.huodongzhuti}';</script>	<script language="javascript">document.form1.huodongdidian.value='${huodongbaoming.huodongdidian}';</script>	<script language="javascript">document.form1.huodongshijian.value='${huodongbaoming.huodongshijian}';</script>	<script language="javascript">document.form1.baomingren.value='${huodongbaoming.baomingren}';</script>	<script language="javascript">document.form1.baomingliyou.value='${huodongbaoming.baomingliyou}';</script>	
					 </table>
			</form>
   </body>
</html>






