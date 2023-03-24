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
				src="<c:url value='templates/user/images/home2.png'/>" alt="">
				<p>Home</p>
			</a> <a href="explore"> <img
				src="<c:url value='templates/user/images/explore.png'/>" alt="">
				<p>Explore</p>
			</a> <a href="subcription"> <img
				src="<c:url value='templates/user/images/subscriprion.png'/>" alt="">
				<p>Subcription</p>
			</a> <a href="<c:url value='library'/>"><img
				src="<c:url value='templates/user/images/library.png'/>" alt="">
				<p>Library</p> </a> <a href="history"> <img
				src="<c:url value='templates/user/images/history.png'/>" alt="">
				<p>History</p>
			</a> <a href="share"> <img
				src="<c:url value='templates/user/images/playlist.png'/>" alt="">
				<p>Playlist</p>
			</a> <a href=""> <img
				src="<c:url value='templates/user/images/messages.png'/>" alt="">
				<p>Messages</p>
			</a> <a href=""> <img
				src="<c:url value='templates/user/images/show-more.png'/>" alt="">
				<p>Show</p>
			</a>
			<hr>
			<div class="subcribed-list">
				<h3>SUBCRIBED</h3>
				<a href=""> <img src="images/Jack.png">
					<p>Jack Nicholson</p>
				</a> <a href=""> <img src="images/simon.png">
					<p>Simon Sim</p>
				</a> <a href=""> <img src="images/tom.png">
					<p>Tom Hardy</p>
				</a> <a href=""> <img src="images/megan.png">
					<p>Megan Mark</p>
				</a> <a href=""> <img src="images/cameron.png">
					<p>James Cameron</p>
				</a>
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
						<img src="images/Jack.png" alt="">
						<div class="vid-info">
							<p class="discription" style="font-size: 15px; font-family: sans-serif; color: black; font-weight: 600" href="">${item.title}</p>
							<p style="margin-bottom: 10px">${item.views} views &bull; 2days</p>
							<p class="flex-div" style="margin: 0px 5% 1% 0px"><img style="border-radius: 50%; width: 35px" alt="" src="templates/user/images/simon.png">
							<span style="padding-left: 5px">Duy Nguyen</span>
							</p>
							
							
							<p class="discription">${item.discription}</p>
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