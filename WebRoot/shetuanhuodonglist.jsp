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
    <title>社团活动</title>

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
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

<%

%>

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
                               社团活动
                            </li>
                            
                        </ul>
                    </div>
                </div>
            </div>
			<div class="container">
            <div class="row">
                
                   <div class="content-form">
                     <link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">    
<form action="sthdList.do" name="myform" method="post" style="width:100%">
									查询   用户名：<input name="yonghuming" type="text" id="yonghuming" class="form-control2" />  姓名：<input name="xingming" type="text" id="xingming" class="form-control2" />  社团名称：<input name="shetuanmingcheng" type="text" id="shetuanmingcheng" class="form-control2" />  社团类型：<input name="shetuanleixing" type="text" id="shetuanleixing" class="form-control2" />  活动主题：<input name="huodongzhuti" type="text" id="huodongzhuti" class="form-control2" />  活动地点：<input name="huodongdidian" type="text" id="huodongdidian" class="form-control2" />  活动时间：<input name="huodongshijian" type="text" id="huodongshijian" class="form-control2" />
									<input type="submit" value="查询" class='hsgqiehuanshitu' /> <input type="button" name="Submit2" value="切换视图" class='hsgqiehuanshitu' onClick="javascript:location.href='sthdListtp.do';" />
								</form>	

	
<br />
<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td bgcolor='#ebf0f7'>用户名</td>    <td bgcolor='#ebf0f7'>姓名</td>    <td bgcolor='#ebf0f7'>社团名称</td>    <td bgcolor='#ebf0f7'>社团类型</td>    <td bgcolor='#ebf0f7'>活动主题</td>    <td bgcolor='#ebf0f7'>活动地点</td>    <td bgcolor='#ebf0f7'>活动时间</td>    <td bgcolor='#ebf0f7' width='90' align='center'>海报</td>        
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="50px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list}" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.yonghuming}</td>    <td>${u.xingming}</td>    <td>${u.shetuanmingcheng}</td>    <td>${u.shetuanleixing}</td>    <td>${u.huodongzhuti}</td>    <td>${u.huodongdidian}</td>    <td>${u.huodongshijian}</td>    <td width='90'><a href='${u.haibao}' target='_blank'><img src='${u.haibao}' width=88 height=99 border=0 /></a></td>        
                              <td align="center"> ${u.addtime} </td>
                              <td align="center"><a class="btn btn-info btn-small" href="sthdDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table>
<br>

<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="sthdList.do?page=1" >首页</a>
             <a href="sthdList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="sthdList.do?page=${page.page+1 }">下一页</a>
			<a href="sthdList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>




                    </div>	
            </div>
			</div>
        </div>
    </div>
<jsp:include page="qtdown.jsp"></jsp:include>

</body></html>
