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
			<a href="index"> <img
				src="<c:url value='templates/user/images/home2.png'/>" alt="">
				<p>Home</p>
			</a> <a href="explore"> <img
				src="<c:url value='templates/user/images/explore.png'/>" alt="">
				<p>Explore</p>
			</a>
			<c:if test="${not empty sessionScope.current_user}">
				<a href="subscriprion"> <img
					src="<c:url value='templates/user/images/subscriprion.png'/>"
					alt="">
					<p>Subcription</p>
				</a>
				<a href="library"> <img
					src="<c:url value='templates/user/images/library.png'/>" alt="">
					<p>Library</p>
				</a>
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

	<div class="container">
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
				<h3 >${video.title}</h3>
				<div class="play-video-info">
					<p>${video.views}&nbsp;Views&nbsp;&bull;&nbsp;
						${video.dayUpload}</p>
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
						<span>${numberSubcriber} Subcribers</span>
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
							<h4>${video.commentnumber}Comments</h4>
							<div class="add-comment">
								<img
									src="<c:url value='templates/user/images/${sessionScope.current_user.avatar}'/>"
									alt=""> <input id="CurrentAccountComment" type="text"
									placeholder="Write comments">
							</div>

							<div class="list_old_comment">
								<c:forEach items='${listComment}' var='item'>
									<div class="old-comment">
										<img src="templates/user/images/${item.avatar}" alt="">
										<div>
											<h3>${item.nameChannel}</h3>
											<p>${item.comment}</p>
										</div>
									</div>
								</c:forEach>
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
	<input id="videoid" type="hidden" value='${video.id}' />
	<input id="videoLikeNumber" type="hidden" value='${video.likenumber}' />
	<input id="videoShareNumber" type="hidden" value='${video.shares}' />
	<input id="currenUserId" type="hidden" value='${video.idUploader}' />
	<input id="sessionUserid" type="hidden"
		value='${sessionScope.current_user.id}' />
	<input id="avatar" type="hidden"
		value='${sessionScope.current_user.avatar}' />
	<input id="nameChannel" type="hidden"
		value='${sessionScope.current_user.nameChannel}' />


	<input id="reverse_like" type="hidden" value='${history.isliked}' />
	<input id="reverse_share" type="hidden" value='${history.isshare}' />
	<input id="reverse_later" type="hidden" value='${history.islater}' />

	<script type="text/javascript">
		var input = document.getElementById("CurrentAccountComment");

		if (input != null) {
			input.addEventListener("keypress", function(event) {
				if (event.key === "Enter") {
					event.preventDefault();
					commentAComment();
				}
			});

			function commentAComment() {
				var videoid = $('#videoid').val();
				var sessionUserid = $('#sessionUserid').val();
				var avatar = $('#avatar').val();
				var comment = input.value;
				var nameChannel = $('#nameChannel').val();
				alert(videoid);
				$
						.ajax({
							type : 'POST',
							url : '/asm2/addComment',
							data : {
								videoid : videoid,
								currentuserid : sessionUserid,
								comment : input.value
							},
							success : function(msg, a) {
								let list_old_comment = $('.list_old_comment');
								list_old_comment
										.append("<div class='old-comment'> <img src='templates/user/images/"+avatar+"' alt=''> <div> <h3>"
												+ nameChannel
												+ "</h3> <p>"
												+ comment + "</p></div> </div>");
							},
							error : function(XMLHttpRequest, textStatus,
									errorThrown) {
								alert("some error " + textStatus);
							}
						})
			}
		}

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
									$('#videoLikeNumber').val(false);
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
									$('#videoLikeNumber').val(true);
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