<%@ include file="/common/user/link.jsp"%>
<nav class="flex-div">
	<div class="nav-left flex-div">
		<img src="<c:url value='templates/user/images/menu.png'/>"
			class="menu-icon" alt=""> <a href="index"> <img
			src="<c:url value='templates/user/images/logo.png'/>"
			class="logo-icon" alt="">
		</a>
	</div>
	<div class="nav-middle flex-div">
		<div class="search-box flex-div">

			<form action="find" method="get">
				<input name="fin" type="text" placeholder="Search">
				<button name="buton" style="border: none; background-color: white" type="submit">
					<img src="<c:url value='templates/user/images/search.png'/>"
						class="">
				</button>
			</form>

		</div>
		<a><img
			src="<c:url value='templates/user/images/voice-search.png'/>"
			class="mic-icon"></a>
	</div>

	<div class="nav-right flex-div">

		<c:choose>
			<c:when test="${not empty sessionScope.current_user}">
				<a href="upload"><img src="<c:url value='templates/user/images/upload.png'/>" alt=""></a>
				<img src="<c:url value='templates/user/images/more.png'/>" alt="">
				<img src="<c:url value='templates/user/images/notification.png'/>"
					alt="" srcset="">
				<a href="<c:url value='logout'/>"><img
					src="<c:url value='templates/user/images/${sessionScope.current_user.avatar}'/>"
					class="user-icon" alt=""></a>
			</c:when>
			<c:otherwise>
				<form action="login">
					<button class="sub"
						style="font-size: 20px; padding: 10px 20px 10px 20px; background: white; color: blue; border-radius: 30px"
						type="submit">Login</button>
				</form>
			</c:otherwise>
		</c:choose>

	</div>
</nav>