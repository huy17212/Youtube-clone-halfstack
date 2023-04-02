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
<%@ include file="/common/user/cdnSweetAlert.jsp"%>
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
				<c:forEach items='${listAccountSubcriber}' var='item'>
					<a href=""> <img src="templates/user/images/${item.avatar}">
						<p>${item.nameChannel}</p>
					</a>
				</c:forEach>
			</div>
		</div>
	</div>

	<div style="margin-left: 60px; padding-left: 10px"
		class="container play-container">
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
					<p>${video.views}Views&bull;${video.dayUpload}</p>
					<div class="buttonDesciption">

						<button type="button" id="likeOrUnlike"
							style="border: 0px none white; background-color: #F9F9F9; margin-right: 20px">
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

						<button type="button" id="shareOrUnshare"
							style="border: 0px none white; background-color: #F9F9F9; margin-right: 20px">
							<c:choose>
								<c:when test="${history.isshare}">
									<img id="1" class="sharebutton" style="width: 20px"
										src="templates/user/images/share2.png" alt="" srcset="">
								</c:when>
								<c:otherwise>
									<img id="2" class="sharebutton" style="width: 20px"
										src="templates/user/images/share.png" alt="" srcset="">
								</c:otherwise>
							</c:choose>
							<h5 id="sharenumber">${video.shares}</h5>
						</button>

						<button type="button" id="saveOrUnsave"
							style="border: 0px none white; background-color: #F9F9F9;">
							<c:choose>
								<c:when test="${history.islater}">
									<img id="1" class="savebutton" style="width: 20px"
										src="templates/user/images/save2.png" alt="" srcset="">
								</c:when>
								<c:otherwise>
									<img id="2" class="savebutton" style="width: 20px"
										src="templates/user/images/save.png" alt="" srcset="">
								</c:otherwise>
							</c:choose>
						</button>

					</div>
				</div>
				<hr>

				<div class="publisher">
					<img src="<c:url value='templates/user/images/${video.avatar}'/>"
						alt="">
					<div>
						<p>${video.uploader}</p>
						<span>500k Subcribers</span> <span>userid
							${sessionScope.current_user.id}</span> <span>idUploader
							${video.idUploader}</span>
					</div>

					<c:if test="${sessionScope.current_user.id ne video.idUploader}">
						<button id="SubcribeOrUnsubcribe" type="button">
							<c:choose>
								<c:when test="${isSubcribe}">
									<p class="subcribeButton" id="5">Subcribe</p>
								</c:when>
								<c:otherwise>
									<p class="subcribeButton" id="6">UnSubcribe</p>
								</c:otherwise>
							</c:choose>
						</button>
					</c:if>


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

				<c:forEach items='${videos}' var='item'>
					<div class="side-video-list">
						<a href="watch?href=${item.href}" class="small-thumnail"> <img
							src="<c:url value='templates/user/images/${item.poster}'/>"
							alt=""></a>
						<div class="vid-info">
							<a href="">${item.title}</a>
							<p>${item.uploader}</p>
							<p>${item.views}views</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


	<input id="videoIdHiddent" type="hidden" value='${video.href}' />
	<input id="videoLikeNumber" type="hidden" value='${video.likenumber}' />
	<input id="videoShareNumber" type="hidden" value='${video.shares}' />
	<input id="currenUserId" type="hidden" value='${video.idUploader}' />

	<script type="text/javascript">
		$('#likeOrUnlike').click(
				function() {
					var href = $('#videoIdHiddent').val();
					var sign = $('.likebutton').attr("id");
					var likenumber = $('#videoLikeNumber').val() * 1;
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
							swal({
								title : "You Have to login to do this done!",
							});
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
									$('#likenumber').html(likenumber + "");
									$('#videoLikeNumber').val(likenumber);
								}).fail(function(err) {
							swal({
								title : "You Have to login to do this done!",
							});
						});
						break;
					}
					}

				});

		$('#saveOrUnsave')
				.click(
						function() {
							var href = $('#videoIdHiddent').val();
							var sign = $('.savebutton').attr("id");
							switch (sign) {
							case "2": {
								$
										.ajax({
											url : 'save?href=' + href
										})
										.then(
												function() {
													$(".savebutton")
															.attr('src',
																	"templates/user/images/save2.png");
													$('.savebutton').attr("id",
															"1");
													swal({
														title : "Thank You for save, that was nice job!",
													});
												})
										.fail(
												function(err) {
													swal({
														title : "Try in next time, sorry mate!",
													});
												});
								break;
							}
							case "1": {
								$
										.ajax({
											url : 'unsave?href=' + href
										})
										.then(
												function() {
													$(".savebutton")
															.attr('src',
																	"templates/user/images/save.png");
													$('.savebutton').attr("id",
															"2");
													swal({
														title : "Thank You! I' ll try to better for save!",
													});
												})
										.fail(
												function(err) {
													swal({
														title : "Try in next time, sorry mate!",
													});
												});
								break;
							}
							}

						});

		$('#SubcribeOrUnsubcribe')
				.click(
						function() {
							var currentUserId = $('#currenUserId').val();
							var sign = $('.subcribeButton').attr("id");
							switch (sign) {
							case "5": {
								$
										.ajax(
												{
													url : 'subcribe?currentUserid='
															+ currentUserId
												})
										.then(
												function() {
													$('.subcribeButton').text(
															"UnSubcribe");
													$('.subcribeButton').attr(
															"id", "6");
													swal({
														title : "Thank You for subcriber me!",
													});
												})
										.fail(
												function(err) {
													swal({
														title : "Try in next time, sorry mate!",
													});
												});
								break;
							}
							case "6": {
								$
										.ajax(
												{
													url : 'unsubcribe?currentUserid='
															+ currentUserId
												})
										.then(
												function() {
													$('.subcribeButton').text(
															"subcribe");
													$('.subcribeButton').attr(
															"id", "5");
													swal({
														title : "Thank You! I' ll try to better for your subcriber",
													});
												})
										.fail(
												function(err) {
													swal({
														title : "Try in next time, sorry mate!",
													});
												});
								break;
							}
							}

						});

		$('#shareOrUnshare')
				.click(
						function() {
							var href = $('#videoIdHiddent').val();
							var sign = $('.sharebutton').attr("id");
							var shareNumber = $('#videoShareNumber').val() * 1;
							switch (sign) {
							case "2": {
								$
										.ajax({
											url : 'share?href=' + href
										})
										.then(
												function() {
													shareNumber++;
													$(".sharebutton")
															.attr('src',
																	"templates/user/images/share2.png");
													$('.sharebutton').attr(
															"id", "1");

													$('#sharenumber').html(
															shareNumber);
													$('#videoShareNumber').val(
															shareNumber);
													swal({
														title : "Thank You!",
													});
												})
										.fail(
												function(err) {
													swal({
														title : "Try in next time, sorry mate!",
													});
												});
								break;
							}
							case "1": {
								$
										.ajax({
											url : 'unshare?href=' + href
										})
										.then(
												function() {
													shareNumber--;
													$(".sharebutton")
															.attr('src',
																	"templates/user/images/share.png");
													$('.sharebutton').attr(
															"id", "2");

													$('#sharenumber').html(
															shareNumber);
													$('#videoShareNumber').val(
															shareNumber);
													swal({
														title : "Thank You!",
													});
												})
										.fail(
												function(err) {
													swal({
														title : "Try in next time, sorry mate!",
													});
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