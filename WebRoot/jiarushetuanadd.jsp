<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>加入社团</title>

    <meta http-equiv="X-UA-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon" href="qtimages/assets/images/favicon.png"/>
    <link rel="stylesheet" href="qtimages/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="qtimages/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="qtimages/assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="qtimages/assets/css/animate.min.css">
    <link rel="stylesheet" href="qtimages/assets/css/jquery-ui.css">
    <link rel="stylesheet" href="qtimages/assets/css/slick.css">
    <link rel="stylesheet" href="qtimages/assets/css/chosen.min.css">
    <link rel="stylesheet" href="qtimages/assets/css/pe-icon-7-stroke.css">
    <link rel="stylesheet" href="qtimages/assets/css/magnific-popup.min.css">
    <link rel="stylesheet" href="qtimages/assets/css/lightbox.min.css">
    <link rel="stylesheet" href="qtimages/assets/js/fancybox/source/jquery.fancybox.css">
    <link rel="stylesheet" href="qtimages/assets/css/jquery.scrollbar.min.css">
    <link rel="stylesheet" href="qtimages/assets/css/mobile-menu.css">
    <link rel="stylesheet" href="qtimages/assets/fonts/flaticon/flaticon.css">
    <link rel="stylesheet" href="qtimages/assets/css/style.css">
	<script type="text/javascript" src="qtimages/js/jquery.data.js"></script>
	<link href="qtimages/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="./qtimages/sl_common_form.css">
</head>
<%
if(request.getSession().getAttribute("username")==null)
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.do';</script>");
	return;
}
  String id="";


 



   %>


	
	<script language="javascript">
function checkform()
{
	
}
function gow()
{
	document.location.href="jiarushetuanadd.jsp?id=<%=id%>";
}
</script>


<body class="inblog-page">
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
    <div class="main-content main-content-blog single left-sidebar">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-trail breadcrumbs">
                        <ul class="trail-items breadcrumb">
                            <li class="trail-item trail-begin">
                                <a href="index.do">首页</a>
                            </li>
                            <li class="trail-item">
                               加入社团
                            </li>
                            
                        </ul>
                    </div>
                </div>
            </div>
			<div class="container">
            <div class="row">
                
                   <div class="content-form">
                     <link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
<link rel="stylesheet" href="images/hsgcommon/commonqt.css" type="text/css">
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>
<% 





%>

  

				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						<form action="addJiarushetuan.do" name="form1" method="post">
						<tr ><td width="200">用户名：</td><td><input name='yonghuming' type='text' id='yonghuming' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.yonghuming.value='<%=connDbBean.readzd("shetuanxinxi","yonghuming","id",request.getParameter("id"))%>';document.form1.yonghuming.setAttribute("readOnly",'true');</script>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("shetuanxinxi","xingming","id",request.getParameter("id"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		<tr ><td width="200">社团名称：</td><td><input name='shetuanmingcheng' type='text' id='shetuanmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.shetuanmingcheng.value='<%=connDbBean.readzd("shetuanxinxi","shetuanmingcheng","id",request.getParameter("id"))%>';document.form1.shetuanmingcheng.setAttribute("readOnly",'true');</script>		<tr ><td width="200">社团类型：</td><td><input name='shetuanleixing' type='text' id='shetuanleixing' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.shetuanleixing.value='<%=connDbBean.readzd("shetuanxinxi","shetuanleixing","id",request.getParameter("id"))%>';document.form1.shetuanleixing.setAttribute("readOnly",'true');</script>		<tr ><td width="200">申请人：</td><td><input name='shenqingren' type='text' id='shenqingren' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		<tr ><td width="200">申请理由：</td><td><input name='shenqingliyou' type='text' id='shenqingliyou' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						      <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="content-form-signup" />
						       <input type="reset" value="重置" class="content-form-signup" />&nbsp;
						    </td>
						</tr>
						</form>
					 </table>
			
			<script language="javascript">popheight = 1050;</script>
                    </div>	
            </div>
			</div>
        </div>
    </div>
<jsp:include page="qtdown.jsp"></jsp:include>

</body></html>
