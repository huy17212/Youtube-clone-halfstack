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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@ include file="/common/user/link.jsp"%>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<style type="text/css">
.file-upload {
	background-color: #ffffff;
	width: 600px;
	margin: 0 auto;
	padding: 20px;
}

.file-upload-btn {
	width: 100%;
	margin: 0;
	color: #fff;
	background: #1FB264;
	border: none;
	padding: 10px;
	border-radius: 4px;
	border-bottom: 4px solid #15824B;
	transition: all .2s ease;
	outline: none;
	text-transform: uppercase;
	font-weight: 700;
}

.file-upload-btn:hover {
	background: #1AA059;
	color: #ffffff;
	transition: all .2s ease;
	cursor: pointer;
}

.file-upload-btn:active {
	border: 0;
	transition: all .2s ease;
}

.file-upload-content {
	display: none;
	text-align: center;
}

.file-upload-input {
	position: absolute;
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	outline: none;
	opacity: 0;
	cursor: pointer;
}

.image-upload-wrap {
	margin-top: 20px;
	border: 4px dashed #1FB264;
	position: relative;
}

.image-dropping, .image-upload-wrap:hover {
	background-color: #1FB264;
	border: 4px dashed #ffffff;
}

.image-title-wrap {
	padding: 0 15px 15px 15px;
	color: #222;
}

.drag-text {
	text-align: center;
}

.drag-text h3 {
	font-weight: 100;
	text-transform: uppercase;
	color: #15824B;
	padding: 60px 0;
}

.file-upload-image {
	max-height: 200px;
	max-width: 200px;
	margin: auto;
	padding: 20px;
}

.remove-image {
	width: 200px;
	margin: 0;
	color: #fff;
	background: #cd4535;
	border: none;
	padding: 10px;
	border-radius: 4px;
	border-bottom: 4px solid #b02818;
	transition: all .2s ease;
	outline: none;
	text-transform: uppercase;
	font-weight: 700;
}

.remove-image:hover {
	background: #c13b2a;
	color: #ffffff;
	transition: all .2s ease;
	cursor: pointer;
}

.remove-image:active {
	border: 0;
	transition: all .2s ease;
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
			</a> <a href="subcription"> <img
				src="<c:url value='templates/user/images/subscriprion.png'/>" alt="">
				<p>Subcription</p>
			</a> <a href="<c:url value='library'/>"><img
				src="<c:url value='templates/user/images/library2.png'/>" alt="">
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
			<img src="<c:url value='templates/user/images/banner.png'/>" alt="">
		</div>


		<div style="display: flex; width: 100%" class="showMore">
			<form action="upload" style="width: 100%" method="POST">
				<div class="file-upload">
					<button class="file-upload-btn" type="button"
						onclick="$('.file-upload-input').trigger('click')">Add
						Image</button>
					<div class="image-upload-wrap">
						<input name="poster" class="file-upload-input" type='file'
							onchange="readURL(this);" accept="video/*" />
						<div class="drag-text">
							<h3>Drag and drop a file or select add Image</h3>
						</div>
					</div>

					<div class="file-upload-content">
						<img class="file-upload-image" src="" alt="your image" />
						<div class="image-title-wrap">
							<button type="button" onclick="removeUpload()"
								class="remove-image">
								Remove <span class="image-title">Uploaded Image</span>
							</button>
						</div>
					</div>
					<div style="margin: 20px 0 20px 0">
						<label style="font-size: 20px">The title of video (At
							least 20 characters)</label> <input name="title" type="text"
							style="width: 100%; height: 60px">
					</div>
					<div style="margin: 20px 0 20px 0">
						<label style="font-size: 20px">The href of video (copy
							from youtube)</label> <input name="href" type="text"
							style="width: 100%; height: 60px">
					</div>

					<div style="margin: 20px 0 20px 0">
						<label style="font-size: 20px">The hashtag of video (One
							hashtag per video)</label> <input name="hashtag" type="text"
							style="width: 100%; height: 60px">
					</div>

					<div style="margin: 20px 0 20px 0">
						<label style="font-size: 20px">The hashtag of video (One
							hashtag per video)</label>

						<div style="display: flex">
							<h4 style="margin-right: 1%; width: 180px">No, I don't want.</h4>
							<input value="0" type="radio" name="isactive">
						</div>

						<div style="display: flex" class="flex-div">
							<h4 style="margin-right: 1%; width: 180px">Yes, do it for sure.</h4>
							<input value="1" type="radio" name="isactive">
						</div>
					</div>


					<textarea name="discription"
						style="width: 100%; height: 300px; resize: none"></textarea>
					<input value="Upload now" size="600"
						style="width: 100%; height: 50px; font-size: 20px; color: white; background: red; border: none; cursor: pointer; font-weight: 600"
						type="submit">
				</div>
			</form>

		</div>
	</div>
	</div>
	<script src="<c:url value='templates/user/javascript/script.js'/>">
		
	</script>

	<script>
		function readURL(input) {
			if (input.files && input.files[0]) {

				var reader = new FileReader();

				reader.onload = function(e) {
					$('.image-upload-wrap').hide();
					$('.file-upload-image').attr('src', e.target.result);
					$('.file-upload-content').show();

					$('.image-title').html(input.files[0].name);
				};

				reader.readAsDataURL(input.files[0]);

			} else {
				removeUpload();
			}
		}

		function removeUpload() {
			$('.file-upload-input')
					.replaceWith($('.file-upload-input').clone());
			$('.file-upload-content').hide();
			$('.image-upload-wrap').show();
		}
		$('.image-upload-wrap').bind('dragover', function() {
			$('.image-upload-wrap').addClass('image-dropping');
		});
		$('.image-upload-wrap').bind('dragleave', function() {
			$('.image-upload-wrap').removeClass('image-dropping');
		});
	</script>

</body>
</html>