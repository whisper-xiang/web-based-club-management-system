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
<form action="sthdListtp.do" name="myform" method="post" style="width:100%">
									查询   用户名：<input name="yonghuming" type="text" id="yonghuming" class="form-control2" />  姓名：<input name="xingming" type="text" id="xingming" class="form-control2" />  社团名称：<input name="shetuanmingcheng" type="text" id="shetuanmingcheng" class="form-control2" />  社团类型：<input name="shetuanleixing" type="text" id="shetuanleixing" class="form-control2" />  活动主题：<input name="huodongzhuti" type="text" id="huodongzhuti" class="form-control2" />  活动地点：<input name="huodongdidian" type="text" id="huodongdidian" class="form-control2" />  活动时间：<input name="huodongshijian" type="text" id="huodongshijian" class="form-control2" />
									<input type="submit" value="查询" class='hsgqiehuanshitu' /> <input type="button" name="Submit2" value="切换视图" class='hsgqiehuanshitu'  onClick="javascript:location.href='sthdList.do';" />
								</form>	
<br />

<table width="100%" height="12%" border="0" align="center" cellpadding="0" cellspacing="0">
                          <tr>
                          <%
					int i=0;
				%>
				<c:forEach items="${list}" var="u">
				<%
					i++;
				%>
                           <td height="316" align="center"><table height="285" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td height="250" align="center"><a href="sthdDetail.do?id=${u.id}"><img src="${u.haibao}" width="210" height="250" border="0" style="border-radius: 18px;" /></a></td>
                                </tr>
                                <tr>
                                  <td height="26" align="center">${u.huodongzhuti}</td>
                                </tr>
                            </table></td>
							  <%
								if (i==4)
								{
									i=0;
									out.print("</tr><tr>");
								}
				  	
					
				  %>
							</c:forEach>
							
                          
                          </tr>
                        </table><br>

<p align="center"> <c:if test="${sessionScope.p==1}">
		 <c:if test="${page.page>1}">
              <a href="sthdListtp.do?page=1" >首页</a>
             <a href="sthdListtp.do?page=${page.page-1}"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="sthdListtp.do?page=${page.page+1}">下一页</a>
			<a href="sthdListtp.do?page=${page.totalPage}">末页</a>		    </c:if>		
	</c:if>
	</p>
                    </div>	
            </div>
			</div>
        </div>
    </div>
<jsp:include page="qtdown.jsp"></jsp:include>

</body></html>
