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
<link rel="stylesheet"
	href="<c:url value='templates/user/css/style.css'/>">
</head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" /></script>
<body>
	<%@ include file="/common/user/navigation.jsp"%>
	
	
	<div class="slidebar">
		<div class="shortcut-links">
			<a href=""> <img
				src="<c:url value='templates/user/images/home.png'/>" alt="">
				<p>Home</p>
			</a> <a href=""> <img
				src="<c:url value='templates/user/images/explore.png'/>" alt="">
				<p>Explore</p>
			</a> <a href=""> <img
				src="<c:url value='templates/user/images/subscriprion.png'/>" alt="">
				<p>Subcription</p>
			</a> <a href=""> <img
				src="<c:url value='templates/user/images/library.png'/>" alt="">
				<p>Library</p>
			</a> <a href=""> <img
				src="<c:url value='templates/user/images/history.png'/>" alt="">
				<p>History</p>
			</a> <a href=""> <img
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
	
	<div style="margin-left: 60px; padding-left: 10px" class="container play-container">
		<div class="row">
			<div class="play-video">
				<div>
					<iframe width="100%" height="400px"
						src='https://www.youtube.com/embed/${video.href}'
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; 
				encrypted-media; gyroscope; picture-in-picture; web-share"
						allowfullscreen> </iframe>
				</div>
				<div class="tags">
					<a href="">${video.hashtag}</a>
				</div>
				<h3>${video.title}</h3>
				<div class="play-video-info">
					<p>${video.views}Views&bull;2daysago</p>
					<div class="buttonDesciption">
					
						<button type="button" id="likeOrUnlike" style="border: 0px none white; background-color: #F9F9F9; margin-right: 20px">
							<c:choose>
								<c:when test="${history.isliked}">
									<img id="1" class="likebutton" style="width: 20px"
										src="templates/user/images/like2.png" alt="" srcset="">
									
							</c:when>
								<c:otherwise>
									<img id="2" class="likebutton" style="width: 20px"
										src="templates/user/images/like.png" alt="" srcset="">
										
								
							</c:otherwise>
							</c:choose>
							<h5 id="likenumber">${video.likenumber}</h5>
						</button>
						
						<button type="button" id="" style="border: 0px none white; background-color: #F9F9F9;  margin-right: 20px">
							<c:choose>
								<c:when test="${history.isliked}">
									<img id="1" class="sharebutton" style="width: 20px"
										src="templates/user/images/share.png" alt="" srcset="">
									
							</c:when>
								<c:otherwise>
									<img id="2" class="sharebutton" style="width: 20px"
										src="templates/user/images/share.png" alt="" srcset="">
										
								
							</c:otherwise>
							</c:choose>
							<h5>${video.shares}</h5>
						</button>
						
						<button type="button" id="" style="border:0px none white;background-color: #F9F9F9;">
							<c:choose>
								<c:when test="${history.isliked}">
									<img id="1" class="savebutton" style="width: 20px"
										src="templates/user/images/save.png" alt="" srcset="">
									
							</c:when>
								<c:otherwise>
									<img id="2" class="savebutton" style="width: 20px"
										src="templates/user/images/save.png" alt="" srcset="">
										
								
							</c:otherwise>
							</c:choose>
							<h5 value="123"></h5>
						</button>
					</div>
				</div>
				<hr>
				<div class="publisher">
					<img src="<c:url value='templates/user/images/Jack.png'/>" alt="">
					<div>
						<p>Easy Toturials</p>
						<span>500k Subcribers</span>
					</div>
					<button type="button">Subcribe</button>
				</div>
				<div class="vid-description">
					<p>${video.discription}</p>
					<hr>
					<c:choose>
						<c:when test="${not empty sessionScope.current_user}">
							<h4>134 Comments</h4>
							<div class="add-comment">
								<img
									src="<c:url value='templates/user/images/${sessionScope.current_user.avatar}'/>"
									alt=""> <input type="text" placeholder="Write comments">
							</div>
							<div class="old-comment">
								<img src="images/Jack.png" alt="">
								<div>
									<h3>
										Jack Nicholson <span> 2 days ago</span>
									</h3>
									<p>This is the best video I can make, So pls subcribe my
										channel for more video in the future.</p>
									<div class="acomment-action">
										<img src="<c:url value='templates/user/images/like.png'/>"
											alt=""> <span>244</span> <img
											src="<c:url value='templates/user/images/dislike.png'/>"
											alt=""> <span>2</span> <span>REPLY</span> <a href="">All
											Replies</a>
									</div>
								</div>
							</div>
						</c:when>
					</c:choose>
				</div>
			</div>

			<div class="right-sidebar">
				<div class="side-video-list">
					<a href="" class="small-thumnail"> <img
						src="<c:url value='templates/user/images/thumbnail3.png'/>" alt=""></a>
					<div class="vid-info">
						<a href="">Best channel for coding</a>
						<p>Easy Toturials</p>
						<p>15k views</p>
					</div>
				</div>
				<div class="side-video-list">
					<a href="" class="small-thumnail"><img
						src="<c:url value='templates/user/images/thumbnail5.png'/>" alt=""></a>
					<div class="vid-info">
						<a href="">Best channel for coding</a>
						<p>Easy Toturials</p>
						<p>15k views</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<input id="videoIdHiddent" type="hidden" value='${video.href}' />
	<input id="videoLikeNumber" type="hidden" value='${video.likenumber}' />

	<script type="text/javascript">
		$('#likeOrUnlike').click(
				function() {
					var href = $('#videoIdHiddent').val();
					var sign = $('.likebutton').attr("id");
					var likenumber = $('#videoLikeNumber').val() * 1;
					console.log(likenumber);
					switch (sign) {
					case "1": {
						$.ajax({
							url : 'dislike?href=' + href
						}).then(
								function() {
									likenumber--;
									$(".likebutton").attr('src',
											"templates/user/images/like.png");
									$('.likebutton').attr("id", "2");
									
									$('#likenumber').html(likenumber);
									$('#videoLikeNumber').val(likenumber);
								}).fail(function(err) {
							alert("Do Again");
						});

						break;
					}
					case "2": {
						$.ajax({
							url : 'like?href=' + href
						}).then(
								function() {
									likenumber++;
									$(".likebutton").attr('src',
											"templates/user/images/like2.png");
									$('.likebutton').attr("id", "1");
									$('#likenumber').html(likenumber+"");
									$('#videoLikeNumber').val(likenumber);
								}).fail(function(err) {
							alert("Do Again");
						});
						break;
					}
					}

				});
	</script>
	
	<script src="<c:url value='templates/user/javascript/script.js'/>">
		
	</script>

</body>
</html>