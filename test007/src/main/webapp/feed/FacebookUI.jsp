<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#face_rectangle {
	background-color: whitesmoke;
	border: 1 black solid;
	width: 550px;
	height: 300px;
	margin: 0 auto;
}

.face {
	border: 1px solid gray;
	width: 50px;
	height: auto;
}

.public_icon {
	width: 15px;
}

#face_under_line img {
	width: 20px;
	height: auto;
}

#face_image_right {
	position: relative;
	float: left
}

#face_image_left {
	float: left;
}

#public_icon_box {
  float: left;
}





</style>

</head>
<body>

	<form method="post" action="">

		<div id="face_rectangle">
			<div id="face_image">
				<img class="face" src="../files/black_boy.png">

				<textarea rows="5" cols="50" name="contents"
					placeholder="지금 기분이 어떠신가요?"></textarea>
			</div>
			<div id="face_under_line">
				<a href=""><img src="../files/camera_icon.png"></a> 
				<a	href="useradd.do"><img src="../files/user_add_icon.svg"></a>
				<select name="workORFeeling">
					<option selected>하는 일 또는 기분?</option>
					<optgroup label="나는 지금">
						<option>신나요</option>
						<option>사랑에 빠졌어요</option>
						<option>더워요</option>
					</optgroup>
					<option>독서 중</option>
					<option>여행 중</option>
					<option>코딩 중</option>
				</select> <select name="publicScope">
					<option selected>전체 공개</option>
					<option>친구만</option>
					<option>나만 보기</option>
				</select> <input type="submit"><br>
				<c:if test="${!empty friends}">
					<span style="font-size: 13px">친구들 : ${friends}</span>
				</c:if>
			</div>
		</div>

		<c:forEach var="feed" items="${feeds}">
			<div id="face_rectangle">
				<div id="face_image">
					<div id="face_image_left">
						<c:choose>
							<c:when test="${!empty feed.attachFile1}">
								<img class="face" src="../files/${feed.attachFile1}">
							</c:when>
							<c:otherwise>
								<img class="face" src="../files/black_boy.png">
							</c:otherwise>
						</c:choose>
					</div>
					<div id="face_image_right">
						<div style="font-size: 15px">${feed.writer}</div> 
						<div style="font-size: 12px; float:left;  margin-top: 4px;">${feed.createDate}</div>
						<div id="public_icon_box">
							<c:choose>
								<c:when test="${feed.publicScope eq 'ALL'}">
									<img class="public_icon" src="../files/earth_icon.png">
								</c:when>
								<c:when test="${feed.publicScope eq 'FRIEND_ONLY'}">
									<img class="public_icon" src="../files/users_icon.png">
								</c:when>
								<c:otherwise>
									<img class="public_icon" src="../files/user_icon.png">
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>


				<textarea rows="5" cols="70" name="contents" readonly>${feed.content}</textarea>

				<div id="face_under_line">
					<a href=""><img src="../files/like_icon.png">좋아요</a>
					<c:if test="${!empty like}">
						<span style="font-size: 13px">${feed.like}</span>
					</c:if>
				</div>
			</div>
		</c:forEach>
	</form>
</body>
</html>