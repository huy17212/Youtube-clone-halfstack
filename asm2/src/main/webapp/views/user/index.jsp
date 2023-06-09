<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/user/taglibJSTL.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<%@ include file="/common/user/link.jsp"%>
</head>
<body>
	<%@ include file="/common/user/navigation.jsp"%>

	<div class="slidebar">
		<div class="shortcut-links">
			<a href="index"> <img
				src="<c:url value='templates/user/images/home2.png'/>" alt="">
				<p>Home</p>
			</a> <a id="explore" href="explore"> <img
				src="<c:url value='templates/user/images/explore.png'/>" alt="">
				<p>Explore</p>
			</a>
			<c:if test="${not empty sessionScope.current_user}">
				<a href="subcription"> <img
					src="<c:url value='templates/user/images/subscriprion.png'/>"
					alt="">
					<p>Subcription</p>
				</a>
				<a href="<c:url value='library'/>"><img
					src="<c:url value='templates/user/images/library.png'/>" alt="">
					<p>Library</p> </a>
				<a href="history"> <img
					src="<c:url value='templates/user/images/history.png'/>" alt="">
					<p>History</p>
				</a>
				<a href="playlist"> <img
					src="<c:url value='templates/user/images/playlist.png'/>" alt="">
					<p>Playlist</p>
				</a>
			</c:if>
			<a href=""> <img
				src="<c:url value='templates/user/images/messages.png'/>" alt="">
				<p>Messages</p>
			</a> <a id="assminmod" href="AdminPowerSystem"> <img
				src="<c:url value='templates/user/images/show-more.png'/>" alt="">
				<p>Admin mode</p>
			</a>
			<hr>
			<div class="subcribed-list">
				<h3>SUBCRIBED</h3>
				<c:forEach items='${listAccountSubcriber}' var='item'>
					<a href=""> <img src="templates/user/images/${item.avatar}">
						<p>${item.nameChannel}</p>
					</a>
				</c:forEach>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="banner">
			<img src="templates/user/images/banner.png" alt="">
		</div>

		<div class="list-container">
			<c:forEach items='${videos}' var='item'>
				<div  class="vid-list">
					<a id="videoid${item.id}" href='watch?href=${item.href}'><img
						src="<c:url value='templates/user/images/${item.poster}'/>"
						class="thumnail" alt=""></a>
					<div class="flex-div">
						<img src="<c:url value='templates/user/images/${item.avatar}'/>"
							alt="">
						<div class="vid-info">
							<a  href="watch?href=${item.href}">${item.title}</a>
							<p >${item.uploader}</p>
							<p>${item.views}views &bull; ${item.dayUpload}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>

	<script src="<c:url value='templates/user/javascript/script.js'/>">
		
	</script>

</body>
</html>