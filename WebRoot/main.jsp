<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
  <head>
    <title>大学生社团管理系统</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="images/css/left-side-menu.css"
    />
    <link rel="stylesheet" type="text/css" href="images/fonts/iconfont.css" />
    <script src="images/js/jquery.min.js"></script>
    <script src="images/js/jquery.slimscroll.min.js"></script>
    <script type="text/javascript" src="images/js/left-side-menu.js"></script>
  </head>
  <body>
    <div
      class="top"
      style="width: 100%; height: 100px; background-color: #397bc5"
      align="center"
    >
      <table width="100%" border="0">
        <tr>
          <td>
            <span
              class="top"
              style="width: 100%; height: 100px; background-color: #397bc5"
              ><img src="images/logo.png" width="250" height="90" alt=""
            /></span>
          </td>
          <td>
            <div>
              <font color="#ffffff"
                >当前用户：${sessionScope.username} 权限：${sessionScope.cx}
                当前日期：<%java.util.Date date = new java.util.Date();
                java.text.SimpleDateFormat format = new
                java.text.SimpleDateFormat("yyyy-MM-dd",
                java.util.Locale.CHINA); String result = format.format(date);
                out.print(result);%>
                <a href="index.jsp" target="_parent" style="color: #ffffff">
                  返回前台</a
                >
                <a href="logout.jsp" target="_parent" style="color: #ffffff">
                  退出</a
                ></font
              >
            </div>
          </td>
        </tr>
      </table>
    </div>
    <div class="left-side-menu">
      <div class="lsm-expand-btn">
        <div class="lsm-mini-btn">
          <label>
            <input type="checkbox" checked="checked" />
            <svg viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
              <circle cx="50" cy="50" r="30" />
              <path class="line--1" d="M0 40h62c18 0 18-20-17 5L31 55" />
              <path class="line--2" d="M0 50h80" />
              <path class="line--3" d="M0 60h62c18 0 18 20-17-5L31 45" />
            </svg>
          </label>
        </div>
      </div>
      <div class="lsm-container">
        <div class="lsm-scroll">
          <div class="lsm-sidebar">
            <ul>
              <%
              if (session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
                return;
              }
              String cx = (String)session.getAttribute("cx");
              if (cx != null) {
                if (cx.equals("超级管理员") || cx.equals("普通管理员")) {
              %>
              <jsp:include page="left_guanliyuan.jsp"></jsp:include>
              <%
                } else if (cx.equals("注册用户")) {
              %>
              <jsp:include page="left_zhuceyonghu.jsp"></jsp:include>
              <%
                }
              }
              %>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="div" style="float: left">
      <iframe
        frameborder="0"
        id="hsgmain"
        name="hsgmain"
        scrolling="auto"
        src="sy.jsp"
        style="
          margin: 0;
          visibility: inherit;
          width: 100%;
          height: 100%;
          z-index: 1;
        "
        onload="InitBulletin()"
      >
      </iframe>
    </div>
  </body>
</html>
