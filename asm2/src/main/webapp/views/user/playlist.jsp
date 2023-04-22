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

<style type="text/css">
.discription {
	padding: 3px 0px 0px 0px;
	display: inline-block;
	text-align: left;
	letter-spacing: 0px;
	color: #7B7B7B;
	opacity: 1;
	overflow: hidden;
	display: -webkit-box;
	position: relative;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
}

.discription:after {
	display: block;
	position: absolute;
	bottom: 0;
	right: 0;
	background-image: linear-gradient(90deg, rgba(255, 255, 255, 0) 0%,
		rgb(255, 255, 255) 40%);
	padding-left: 15px;
}
</style>

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
					src="<c:url value='templates/user/images/library.png'/>" alt="">
					<p>Library</p> </a>
				<a href="history"> <img
					src="<c:url value='templates/user/images/history.png'/>" alt="">
					<p>History</p>
				</a>
				<a href="playlist"> <img
					src="<c:url value='templates/user/images/playlist2.png'/>" alt="">
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
		<div class="banner">
			<img src="images/banner.png" alt="">
		</div>

		<div class="list-container1">
			<c:forEach items='${videos}' var='item'>
				<div class="vid-list1" style="display: flex; margin-bottom: 10px;">
					<a href='watch?href=${item.href}'><img
						src="<c:url value='templates/user/images/${item.poster}'/>"
						class="thumnail" style="width: 100%; border-radius: 10px;" alt=""></a>
					<div class="flex-div"
						style="width: 86%; align-items: flex-start; margin: 1% 10% 0px 3%;">
						<div class="vid-info">
							<p class="discription"
								style="font-size: 15px; font-family: sans-serif; color: black; font-weight: 600"
								href="">${item.title}</p>
							<p style="margin-bottom: 10px">${item.views}&nbsp;views&nbsp;&bull;&nbsp;2days</p>
							<p class="flex-div" style="margin: 0px 5% 1% 0px">
								<img style="border-radius: 50%; width: 35px" alt=""
									src="templates/user/images/${item.avatar} "> <span
									style="padding-left: 5px">${item.uploader}</span>
							</p>
							<p class="discription">${item.discription}</p>
						</div>
					</div>
				</div>
			</c:forEach>

			<center>
				<c:forEach begin="1" end="${pageSize}" step="1" varStatus="loop">
					<button
						style="width: 50px; height: 20px; cursor: pointer; font-family: sans-serif; background-color: #e74c3c; color: #ffffff; font-size: 15px; border: none"
						onclick="loadTheNextPage(${pageSize})" type="button"
						value="${loop.count}">${loop.count}</button>
				</c:forEach>
			</center>

		</div>

	</div>

	<script src="<c:url value='templates/user/javascript/script.js'/>">
		
	</script>

	<script type="text/javascript">
			function loadTheNextPage(pageNumber){
				
				
				
			}
			
	</script>

</body>
</html>