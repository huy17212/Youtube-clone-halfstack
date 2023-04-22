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
			<img src="images/banner.png" alt="">
		</div>

		<div class="list-container1">
			<div id="varka">
				<c:forEach begin="0" end="1" step="1" varStatus="loop">
					<div class="vid-list1" style="display: flex; margin-bottom: 10px;">
						<a href='watch?href=${videos[loop.count-1].href}'><img
							src="<c:url value='templates/user/images/${videos[loop.count-1].poster}'/>"
							class="thumnail" style="width: 100%; border-radius: 10px;" alt=""></a>
						<div class="flex-div"
							style="width: 86%; align-items: flex-start; margin: 1% 10% 0px 3%;">
							<div class="vid-info">
								<p class="discription"
									style="font-size: 15px; font-family: sans-serif; color: black; font-weight: 600"
									href="">${videos[loop.count-1].title}</p>
								<p style="margin-bottom: 10px">${videos[loop.count-1].views}&nbsp;views&nbsp;&bull;&nbsp;${videos[loop.count-1].dayUpload}</p>
								<p class="flex-div" style="margin: 0px 5% 1% 0px">
									<img style="border-radius: 50%; width: 35px" alt=""
										src="templates/user/images/${videos[loop.count-1].avatar} ">
									<span style="padding-left: 5px">${videos[loop.count-1].uploader}</span>
								</p>
								<p class="discription">${videos[loop.count-1].discription}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<center>
				<c:forEach begin="1" end="${pageNumber}" step="1" varStatus="loop">
					<button
						style="width: 50px; height: 20px; cursor: pointer; font-family: sans-serif; background-color: #e74c3c; color: #ffffff; font-size: 15px; border: none"
						onclick="loadTheNextPage(${loop.count -1})" type="button"
						value="${loop.count}">${loop.count}</button>
				</c:forEach>
			</center>

		</div>

	</div>

	<input type="hidden" id="pageNumber" value="${pageNumber -1}">
	<input type="hidden" id="pageSize" value="${pageSize}">
	<input type="hidden" id="videos" value="${videos}">

	<script src="<c:url value='templates/user/javascript/script.js'/>">
		
	</script>

	<script type="text/javascript">
			var videodkv = [];
			
					<c:forEach begin="0" end="${videolength}" step="1" varStatus="loop">
					videodkv[${loop.count-1}]= {	    
					    id: "${videos[loop.count-1].id}",

						title: "${videos[loop.count-1].title}",

						discription: "${videos[loop.count-1].discription}",

						href: "${videos[loop.count-1].href}",

						poster: "${videos[loop.count-1].poster}",

						views: "${videos[loop.count-1].views}",

						shares: "${videos[loop.count-1].shares}",

						likenumber: "${videos[loop.count-1].likenumber}",

						commentnumber: "${videos[loop.count-1].commentnumber}",
						
						dayUpload: "${videos[loop.count-1].dayUpload}",
						
						hashtag: "${videos[loop.count-1].hashtag}",

						uploader: "${videos[loop.count-1].uploader}",
						
						idUploader: "${videos[loop.count-1].idUploader}",

						avatar: "${videos[loop.count-1].avatar}"
					  }
					</c:forEach>
					
	
				function loadTheNextPage(pageNumber){
				var k = document.querySelector("#varka");
				var number = document.querySelector("#pageNumber").value;
				var size = document.querySelector("#pageSize").value;
				
				var begin = pageNumber * 2;
				var end =  pageNumber * 2 + 2;	
				
				if(begin > ${videolength}){
					console.log(begin);
					end = ${videolength};
				}
				
					
				var vat = "";
				
				
				for(let k  = begin; k < end; k++){
					vat = vat + "<div class='vid-list1' style='display: flex; margin-bottom: 10px;'> " +
			    	"<a href='watch?href="+videodkv[k].href+"'><img" +
			        " src='templates//user//images//"+videodkv[k].poster+ "' class='thumn" + 
			        "ail' style='width: 100%; border-radius: 10px;' alt=''></a> " +
			    	"<div class='flex-div' " +
			        "style='width: 86%; align-items: flex-start; margin: 1% 10% 0px 3%;'> " +
			        "<div class='vid-info'> " +
			        "<p class='discription' " +
			        "style='font-size: 15px; font-family: sans-serif; color: black; font-weight: 600' " +
			        "href=''>"+videodkv[k].title+"</p> " +
			        "<p style='margin-bottom: 10px'>"+videodkv[k].title+"&nbsp;views&nbsp;&bull;&nbsp;"+videodkv[k].dayUpload+"</p> " +
			        "<p class='flex-div' style='margin: 0px 5% 1% 0px'> "+
			        "<img style='border-radius: 50%; width: 35px' alt='' "+
			       	"src='templates/user/images/"+videodkv[k].avatar+"'> " +
			        "<span style='padding-left: 5px'>"+videodkv[k].uploader+"</span> " +
			        "</p><p class='discription'>"+videodkv[k].discription+"</p> " +
			        "</div></div></div>";
				}
				k.innerHTML = vat;
			}
			
	</script>

</body>
</html>