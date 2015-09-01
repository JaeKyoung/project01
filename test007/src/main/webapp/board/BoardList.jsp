<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시물 목록</title>

<jsp:include page="/Header.jsp"/>

<style type="text/css">

table {
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 5px;
}
</style>
</head>
<body>
<jsp:include page="/LoginInfo.jsp"/>
	<h1>게시물 목록-JSP</h1>
	<p>
		<a href='form.html'>새 글</a>
	</p>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		
<%--
  JSTL ( JSP Standard Tag Library )
  => JSP에서 사용할 수 있는 확장 라이브러리
  => API와 구현체를 다운로드 받아야 한다.
 --%>

<c:forEach var="board" items="${boards}">
  <tr>
    <td>${board.no}</td>
    <td><a href='detail.do?no=${board.no}'>${board.title}</a></td>
    <td>${board.createDate}</td>
    <td>${board.viewCount}</td>
  </tr>
</c:forEach>
</table>

<jsp:include page="/Footer.jsp"></jsp:include>

</body>
</html>
