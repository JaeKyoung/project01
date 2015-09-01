<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
select {
	width: 150px;
}

#add_box {
	margin: 0 auto;
	text-align: center;
}

#fieldset {
  display: inline;
}


</style>
</head>
<body>


	<form method="post" action="insert.do">
		<div>

			<div id="add_box">
			<fieldset id="fieldset">
			<legend>친구들</legend>
				<select size="10" name="feedFriends"  multiple >
					<c:forEach var="member" items="${members}">
					 <option>${member.name}</option>
					</c:forEach>
				</select> <br>
				
			
				<input type="submit" value="추가">
				</fieldset>
			</div>
		</div>
	</form>

</body>
</html>