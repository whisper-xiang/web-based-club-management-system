<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<header class="header style2">
    <div class="container">
        <div class="main-header">
            <div class="row">
                <div class="col-lg-4 col-sm-6 col-md-4 col-xs-7 col-ts-12 header-element">
                    <div class="block-search-block">
                        <form class="form-search" action='xwtzList.do' method="post">
                            <div class="form-content">
                                <div class="inner">
                                    <input type="text"  name='biaoti' value="" placeholder="搜索" class="input">
                                    <button class="btn-search" type="submit">
                                        <span class="icon-search"></span>                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 col-md-4 col-xs-5 col-ts-12">
                    <div class="logo">
                        <a href="index.do">
                            <table   border="0">
  <tr>
    <td> <img src="qtimages/assets/images/logo.png" alt="logo"></td>
    <td  align="left"><div style="text-shadow:#CCCCCC 3px 0 0,#33CC33 0 1px 0,#33CC33 1px 0 0,#33CC33 0 0px 0; font-size:28px;" >
                    &nbsp;&nbsp;大学生社团管理系统
                </div></td>
  </tr>
</table>
                        </a>                    </div>
                </div>
                <div class="col-lg-4 col-sm-12 col-md-4 col-xs-12 col-ts-12">
                    <div class="header-control">
                        <div class="block-minicart cleric-mini-cart block-header cleric-dropdown">
                            <a href="javascript:void(0);" class="shopcart-icon" data-cleric="cleric-dropdown">
                                会员                            </a>
                            <div class="no-product cleric-submenu">
                                <p class="text">
                                   
								    <%
    if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")==""){
     %>
                                    <span>
                                        <a href="userlog.jsp">登录</a>                                    </span>
                                    |
                                    <span>
                                        <a href="userreg.jsp">注册</a>                                    </span> 
								<%}else{ %>
				  <%=request.getSession().getAttribute("username")%>,[ <%=request.getSession().getAttribute("cx")%>]&nbsp; <a href="logout.jsp" onclick="return confirm('确定要退出？')" >退出</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="main.jsp" >后台</a>
				  <%} %>
				  
				    </p>
                            </div>
                        </div>
                        <a class="menu-bar mobile-navigation menu-toggle" href="#">
                            <span></span>
                            <span></span>
                            <span></span>                        </a>                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="nav_bg clearfix ">
  <div class="container ">
            <ul id="nav">
                <li><a href="index.do">网站首页</a></li>
				

		 		<li><a class="hsubs" style="cursor:pointer" >社团信息</a>
                    <ul class="subs">
						<li><a href="stxxListtp.do">社团信息</a></li> 
                    </ul>
                </li><li><a class="hsubs" style="cursor:pointer" >社团活动</a>
                    <ul class="subs">
						<li><a href="sthdListtp.do">社团活动</a></li> 
                    </ul>
                </li><li><a class="hsubs" style="cursor:pointer" >网站公告</a>
                    <ul class="subs">
						<li><a href="xwtzList.do?lb=网站公告">网站公告</a></li> 
                    </ul>
                </li><li><a class="hsubs" style="cursor:pointer" >系统概要</a>
                    <ul class="subs">
						<li><a href="dx_detail.jsp?lb=系统简介">系统简介</a></li> <li><a href="dx_detail.jsp?lb=关于我们">关于我们</a></li> <li><a href="dx_detail.jsp?lb=联系方式">联系方式</a></li> 
                    </ul>
                </li><li><a class="hsubs" style="cursor:pointer" >在线留言</a>
                    <ul class="subs">
						<li><a href="lyb.jsp">在线留言</a></li> <li><a href="lybList.do">查看留言</a></li> 
                    </ul>
                </li><!--yoxulixuyaxn-->
                <li><a href="login.jsp">后台管理</a></li>
                <div id="lavalamp"></div>
            </ul>

    </div>
 </div>
</header>