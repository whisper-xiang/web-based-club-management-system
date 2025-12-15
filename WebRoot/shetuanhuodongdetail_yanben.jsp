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
<script language=javascript src='js/popup.js'></script>
<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'在线评论',550,250) ;
}
</script> 
<%
	String id=request.getParameter("id");
	
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
                     
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%' height=44>用户名：</td><td width='39%'>${shetuanhuodong.yonghuming}</td><td  rowspan=7 align=center><a href=${shetuanhuodong.haibao} target=_blank><img src=${shetuanhuodong.haibao}  width=228 height=215 border=0></a></td></tr><tr>         <td width='11%' height=44>姓名：</td><td width='39%'>${shetuanhuodong.xingming}</td></tr><tr>         <td width='11%' height=44>社团名称：</td><td width='39%'>${shetuanhuodong.shetuanmingcheng}</td></tr><tr>         <td width='11%' height=44>社团类型：</td><td width='39%'>${shetuanhuodong.shetuanleixing}</td></tr><tr>         <td width='11%' height=44>活动主题：</td><td width='39%'>${shetuanhuodong.huodongzhuti}</td></tr><tr>         <td width='11%' height=44>活动地点：</td><td width='39%'>${shetuanhuodong.huodongdidian}</td></tr><tr>         <td width='11%' height=44>活动时间：</td><td width='39%'>${shetuanhuodong.huodongshijian}</td></tr><tr>                           <td width='11%' height=100  >简介：</td><td width='39%' colspan=2 height=100 >${shetuanhuodong.jianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回  class='hsgqiehuanshitu' onClick="javascript:history.back()" /><input type=button name=Submit52 value=打印 class='hsgqiehuanshitu' onClick="javascript:window.print()" /> <!--jixaaxnnxiu--></td></tr>
    
  </table>
                    </div>	
            </div>
			</div>
        </div>
    </div>
<jsp:include page="qtdown.jsp"></jsp:include>

</body></html>

