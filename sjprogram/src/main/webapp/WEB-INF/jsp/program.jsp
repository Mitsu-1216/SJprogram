<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Site" %>
<!DOCTYPE html>
<%
Site site =(Site) application.getAttribute("site");
%>
<html>
<head>
<meta charset="UTF-8">
<title>ページ</title>
</head>
<body>
<h1>ようこそ!</h1>
<p>
<a href="/Java_JSP/Index?action=like">Good!</a>:
<%= site.getLike() %>人
<a href="/Java_JSP/Index?action=dislike">Bad!</a>:
<%= site.getDislike() %>人
</p>

</body>
</html>