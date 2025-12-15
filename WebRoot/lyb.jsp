<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>在线留言</title>
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
                                <a href="index.do">在线留言</a>
                            </li>
                            <li class="trail-item">
                               
                            </li>
                            
                        </ul>
                    </div>
                </div>
            </div>
			<div class="container">
            <div class="row">
                <div class="content-form">
                   
                        <form action="addLiuyanban.do" name="form1" method="post">
						<table width="100%" height="757" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" class="newsline" style="border-collapse:collapse">
						 
                            <tr>
                              <td width="12%">昵称：</td>
                              <td width="88%" align="left"><input name='cheng' type='text' id='cheng' value='' onblur='checkform()'  class="user" /> <label id='clabelcheng' />
                              *</td>
                            </tr>
                            <tr>
                              <td>头像：</td>
                              <td align="left"><input name="xingbie" type="radio" value="1" checked>
                                  <img src="img/1.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="2">
                                  <img src="img/2.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="3">
                                  <img src="img/3.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="4">
                                  <img src="img/4.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="5">
                              <img src="img/5.gif" width="64" height="71"></td>
                            </tr>
                            <tr>
                              <td>QQ：</td>
                              <td align="left"><input name='QQ' type='text' id='QQ' value='' class="user" /></td>
                            </tr>
                            <tr>
                              <td>邮箱：</td>
                              <td align="left"><input name='youxiang' type='text' id='youxiang' value='' class="user" onblur='checkform()' /> <label id='clabelyouxiang' />必需邮箱格式</td>
                            </tr>
                            <tr>
                              <td>手机：</td>
                              <td align="left"><input name='shouji' type='text' id='shouji' value='' class="user" onblur='checkform()' /> <label id='clabelshouji' /> 必需手机格式</td>
                            </tr>
                            <tr>
                              <td>内容：</td>
                              <td align="left"><textarea name="neirong" style="width:800px; height:120px;" id="neirong" class="user" onblur='checkform()'></textarea>
                              * <label id='clabelneirong' /> </td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                              <td align="left"> <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="content-form-signup"/>
                              <input type="reset" name="Submit22" value="重置" class="content-form-signup"  /></td>
                            </tr>
                         
                   </table>
		        </form>
                    
					</div>
            </div>
			</div>
        </div>
    </div>
<jsp:include page="qtdown.jsp"></jsp:include>
</body>
</html>