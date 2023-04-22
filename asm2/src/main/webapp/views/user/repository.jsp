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
				src="<c:url value='templates/user/images/home.png'/>" alt="">
				<p>Home</p>
			</a> <a href="explore"> <img
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
					src="<c:url value='templates/user/images/library2.png'/>" alt="">
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
			</a> <a href="AdminPowerSystem"> <img
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
		<h3>List video upload</h3>
		<div style="display: flex" class="showMore">
			<div class="list-container" style="width: 70%">
				<c:forEach items='${listUpload}' var='item'>
					<div class="vid-list">
						<a href='watch?href=${item.href}'><img
							src="<c:url value='templates/user/images/${item.poster}'/>"
							class="thumnail" alt=""></a>
						<div class="flex-div">
							<img src="templates/user/images/${item.avatar}" alt="">
							<div class="vid-info">
								<a href="">${item.title}</a>
								<p>${item.uploader}</p>
								<p>${item.views}&nbsp;views&nbsp;&bull;&nbsp;${item.dayUpload}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="showInfoRepository"
				style="height: 550px; border: 0px none white; width: 29.5%; margin: 16px 0 0 1.5%">

				<center style="margin-top: 40px">
					<img style="border-radius: 50%; width: 10vw" alt=""
						src="templates/user/images/${sessionScope.current_user.avatar}">
					<h4>${sessionScope.current_user.nameChannel}</h4>
				</center>

				<hr style="margin: 20px 10px 20px 10px">
				<div style="display: flex; font-size: 1.75vw;">
					<label style="margin-left: 5%; width: 60px">Uploads: </label>
					<p style="margin-left: 25%">${numberUp}&nbsp;videos</p>
				</div>
				<hr style="margin: 20px 10px 20px 10px">
				<div style="display: flex; font-size: 1.75vw;">
					<label style="margin-left: 5%; width: 60px">Shares: </label>
					<p style="margin-left: 25%">${numberSh}&nbsp;videos</p>
				</div>
				<hr style="margin: 20px 10px 20px 10px">
				<div style="display: flex; font-size: 1.75vw;">
					<label style="margin-left: 5%; width: 60px">Likes: </label>
					<p style="margin-left: 25%">${numberLi}&nbsp;videos</p>
				</div>
			</div>
		</div>





		<h3 style="margin-top: 10px">List video shares</h3>
		<div style="display: flex" class="showMore">
			<div class="list-container" style="width: 70%">
				<c:forEach items='${listShare}' var='item'>
					<div class="vid-list">
						<a href='watch?href=${item.href}'><img
							src="<c:url value='templates/user/images/${item.poster}'/>"
							class="thumnail" alt=""></a>
						<div class="flex-div">
							<img src="templates/user/images/${item.avatar}" alt="">
							<div class="vid-info">
								<a href="">${item.title}</a>
								<p>${item.uploader}</p>
								<p>${item.views}&nbsp;views&nbsp;&bull;&nbsp;${item.dayUpload}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<h3 style="margin-top: 10px">List video like</h3>
		<div style="display: flex" class="showMore">
			<div class="list-container" style="width: 70%">
				<c:forEach items='${listLike}' var='item'>
					<div class="vid-list">
						<a href='watch?href=${item.href}'><img
							src="<c:url value='templates/user/images/${item.poster}'/>"
							class="thumnail" alt=""></a>
						<div class="flex-div">
							<img src="templates/user/images/${item.avatar}" alt="">
							<div class="vid-info">
								<a href="">${item.title}</a>
								<p>${item.uploader}</p>
								<p>${item.views}&nbsp;views&nbsp;&bull;&nbsp;${item.dayUpload}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<script src="<c:url value='templates/user/javascript/script.js'/>">
		
	</script>
</body>
</html>