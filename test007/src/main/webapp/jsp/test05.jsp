<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <meta charset="UTF-8">
  <head></head>
  <body>
  
  <fmt:parseDate var="date1" value="${param.date}" pattern="yyyy-MM-dd"/>
  

<%
Date mydate= (Date)pageContext.getAttribute("date1");
%>

<fmt:formatDate value="${date1}" pattern="yyyy/MM/dd"/>
</body>
</html>