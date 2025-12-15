<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>首页</title>
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
<body class="home">
<jsp:include page="qttop.jsp"></jsp:include>
<div class="">
    <div class="fullwidth-template">
        <jsp:include page="bht.jsp"></jsp:include>
		<div class="cleric-product produc-featured rows-space-40">
            <div class="container">
                <h3 class="custommenu-title-blog">
                    社团活动推荐                </h3>
                <ul class="row list-products auto-clear equal-container product-grid">
                    <%
		 int spi=0;
		 %>
		 <c:forEach items="${syshetuanhuodong}" var="a">
		 <%
		 	spi++;
			if(spi<=8)
			{
		 %>
				    <li class="product-item  col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">
                        <div class="product-inner equal-element">
                            <div class="product-top">
                                <div class="flash"><span class="onnew"><span class="text">new</span></span></div>
                            </div>
                            <div class="product-thumb">
                                <div class="thumb-inner"><a href="sthdDetail.do?id=${a.id}"><img src="${a.haibao}" alt="img"></a></div>
                            </div>
                            <div class="product-info">
                                <h5 class="product-name product_title"><a href="sthdDetail.do?id=${a.id}">${a.huodongzhuti}</a></h5>
                                <div class="group-info">
                                    <div class="stars-rating"><div class="star-rating"><span class="star-2"></span></div></div>
                                </div>
                            </div>
                        </div>
                    </li>
						<%
			}
			%>
		</c:forEach>	
					
                </ul>
            </div>
        </div>
         <div class="cleric-product layout1">
            <div class="container">
                <div class="container-wapper">
                    <div class="head">
                        <h3 class="title">社团</h3>
                        <div class="subtitle">系统自动排序！</div>
                    </div>
                    <div class="product-list-owl owl-slick equal-container nav-center-left"
                         data-slick='{"autoplay":false, "autoplaySpeed":1000, "arrows":true, "dots":false, "infinite":true, "speed":800,"infinite":false}'
                         data-responsive='[{"breakpoint":"2000","settings":{"slidesToShow":3}},{"breakpoint":"1200","settings":{"slidesToShow":2}},{"breakpoint":"992","settings":{"slidesToShow":1}},{"breakpoint":"768","settings":{"slidesToShow":2}},{"breakpoint":"481","settings":{"slidesToShow":1}}]'>
					  <%
		 int txi=0;
		 %>
       <c:forEach items="${syshetuanxinxi}" var="b">
	   <%
		 	txi++;
			if(txi<=8)
			{
		 %>
					    <div class="product-item style-1 product-type-variable">
                            <div class="product-inner equal-element">
                                <div class="product-top">
                                    <div class="flash"><span class="onnew"><span class="text"> new	</span></span></div>
                                </div>
                                <div class="product-thumb">
                                    <div class="thumb-inner"><a href="stxxDetail.do?id=${b.id}"><img src="${b.tupian}" alt="img"></a></div>
                                </div>
                                <div class="product-info">
                                    <h5 class="product-name product_title">
                                        <a href="stxxDetail.do?id=${b.id}">${b.shetuanmingcheng}</a></h5>
                                    <div class="group-info">
                                        <div class="stars-rating"><div class="star-rating"><span class="star-3"></span></div></div>
                                    </div>
                                </div>
                            </div>
                        </div>
						
						<%
			}
			%>
		</c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <div class="cleric-blog-wraap default">
            <div class="container">
                <h3 class="custommenu-title-blog">
                    网站公告                </h3>
                <div class="cleric-blog style2">
                    <div class="newss_list">
            <ul>
			  <table width="97%" border="0" align="center" cellpadding="0" cellspacing="0" class="newsline">
                     <%
				  	int xwi=0;
				  %>
				  <c:forEach items="${syxinwentongzhi1 }" var="a">
				  <%
				  	xwi++;
					if(xwi<8)
					{
				  %>
                      <tr height="25">
                        <td width="2%" height="43" align="center" class="newsline"><img height="7" src="qtimages/fuxing_26.gif"  /></td>
                        <td width="65%" align="left" class="newsline"><a href="xwtzDetail.do?id=${a.id}">${fn:substring(a.biaoti, 0, 34)}</a></td>
                        <td width="11%" class="newsline">被点击${a.dianjilv}次</td>
                        <td width="22%" class="newsline">${a.addtime}</td>
                      </tr>
                    	<%
					}
					%>
                   </c:forEach>
                    </table>
             
            </ul>
          </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="qtdown.jsp"></jsp:include>
</body>
</html>