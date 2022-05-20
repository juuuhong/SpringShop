<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>main</title>
<!-- 부트스트랩 css 사용 -->
<link rel="stylesheet" href="/resources/css/datepicker.min.css">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<script type="text/javascript" src="/resources/js/jquery.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<script type="text/javascript" src="/resources/js/datepicker.min.js"></script>
<script type="text/javascript" src="/resources/js/datepicker.ko.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/ckeditor.js"></script>
<script src="/resources/js/ko.js"></script>
<!-- 넓이 높이 조절 -->
<style>
	.ck.ck-editor {
    	max-width: 1000px;
	}
	.ck-editor__editable {
	    min-height: 500px;
	}
</style>
</head>
<!--  부트스트랩 js 사용 -->
<body>
	<!-- header -->
	<div class="jumbotron text-center mb-0">
		<h1>Homepage</h1>
		<p>JuHong</p>
	</div>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a href="/" class="navbar-brand">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-between" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a href="/notice" class="nav-link">공지사항</a></li>
				<li class="nav-item"><a href="/gallery" class="nav-link">갤러리</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${loginUser eq null}">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">
									접속하기<span class="caret"></span>
							</a>
						 	<ul class="dropdown-menu">
								<li class="list-group-item list-group-item-action">
									<a href="/login">로그인</a>
								</li>
								<li class="list-group-item list-group-item-action">
									<a href="/signUp">회원가입</a>
								</li>
							</ul>
						</li>
					</c:when>
					<c:otherwise>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">
									${loginUser.name } 님<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li class="list-group-item list-group-item-action">
									<a href="/myPage">마이페이지</a>
								</li>
								<li class="list-group-item list-group-item-action">
									<a href="/logout">logout</a>
								</li>
							</ul>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>

	<!-- content -->
	<div class="container pt-3">
		<jsp:include page="${content }" />
	</div>

	<!-- footer -->
	<div class="jumbotron text-center mt-5 mb-0 ">
		<footer class="py-1 my-2">
			<ul class="nav justify-content-center border-bottom pb-1 mb-1">
				<li class="nav-item"><a href="/"
					class="nav-link px-2 text-muted">Home</a></li>
				<li class="nav-item"><a href="/notice"
					class="nav-link px-2 text-muted">공지사항</a></li>
				<li class="nav-item"><a href="/gallery"
					class="nav-link px-2 text-muted">갤러리</a></li>
			</ul>
			<p class="text-center text-muted">&copy; 2022.</p>
		</footer>
	</div>
	<script>
		let msg = "${MSG }";
		if (msg != '') {
			alert(msg);
		}
		
	</script>

</body>
</html>
