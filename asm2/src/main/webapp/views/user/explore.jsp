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
				src="<c:url value='templates/user/images/explore2.png'/>" alt="">
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
			<img src="templates/user/images/banner.png" alt="">
		</div>

		<c:if test="${ListSongsign}">
			<h3 style="height: auto; margin-top: 15px">Top 3 video of study,
				which is has better view in our Vidtube.</h3>
			<div class="list-container">
				<c:forEach begin="0" end="2" step="1" varStatus="loop">
					<div class="vid-list">
						<a href='watch?href=${ListStudy[loop.count - 1].href}'><img
							src="<c:url value='templates/user/images/${ListStudy[loop.count -1 ].poster}'/>"
							class="thumnail" alt=""></a>
						<div class="flex-div">
							<img
								src="<c:url value='templates/user/images/${ListStudy[loop.count -1 ].avatar}'/>"
								alt="">
							<div class="vid-info">
								<a href="watch?href=${ListStudy[loop.count-1].href}">${ListStudy[loop.count-1].title}</a>
								<p>${ListStudy[loop.count-1].uploader}</p>
								<p>${ListStudy[loop.count-1].views}&nbsp;views&nbsp;&bull;&nbsp;
									${ListStudy[loop.count-1].dayUpload}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>


		<c:if test="${ListStudysign}">
			<h3 style="height: auto; margin-top: 15px">Top 3 video of song,
				which is has better view in our Vidtube.</h3>
			<div class="list-container">
				<c:forEach begin="0" end="2" step="1" varStatus="loop">
					<div class="vid-list">
						<a href='watch?href=${ListSong[loop.count - 1].href}'><img
							src="<c:url value='templates/user/images/${ListSong[loop.count -1 ].poster}'/>"
							class="thumnail" alt=""></a>
						<div class="flex-div">
							<img
								src="<c:url value='templates/user/images/${ListSong[loop.count -1 ].avatar}'/>"
								alt="">
							<div class="vid-info">
								<a href="watch?href=${ListSong[loop.count-1].href}">${ListSong[loop.count-1].title}</a>
								<p>${ListSong[loop.count-1].uploader}</p>
								<p>${ListSong[loop.count-1].views}&nbsp;views&nbsp;&bull;&nbsp;
									${ListSong[loop.count-1].dayUpload}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>


		<c:if test="${ListGamesign}">
			<h3 style="height: auto; margin-top: 15px">Top 3 video of games,
				which is has better view in our Vidtube.</h3>
			<div class="list-container">
				<c:forEach begin="0" end="2" step="1" varStatus="loop">
					<div class="vid-list">
						<a href='watch?href=${ListGame[loop.count - 1].href}'><img
							src="<c:url value='templates/user/images/${ListGame[loop.count -1 ].poster}'/>"
							class="thumnail" alt=""></a>
						<div class="flex-div">
							<img
								src="<c:url value='templates/user/images/${ListGame[loop.count -1 ].avatar}'/>"
								alt="">
							<div class="vid-info">
								<a href="watch?href=${ListGame[loop.count-1].href}">${ListGame[loop.count-1].title}</a>
								<p>${ListGame[loop.count-1].uploader}</p>
								<p>${ListGame[loop.count-1].views}&nbsp;views&nbsp;&bull;&nbsp;
									${ListGame[loop.count-1].dayUpload}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>


	</div>

	</div>

	<script src="<c:url value='templates/user/javascript/script.js'/>">
		
	</script>

</body>
</html>