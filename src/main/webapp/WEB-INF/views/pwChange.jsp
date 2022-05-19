<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>

<body>
<div class="container pt-3">
<form action="/newPw" method="post">
	<div class="form-group has-success">
		<label class="form-label mt-4" for="pw">기존비밀번호(*)</label>
		<input type="password" class="form-control is-valid" name="pw" id="pw">
		<div class="valid-feedback"></div>
	</div>
	<div class="form-group has-success">
		<label class="form-label mt-4" for="pw">새 비밀번호(*)</label>
		<input type="password" class="form-control is-valid" name="newPw" id="newPw">
		<div class="valid-feedback"></div>
	</div>
	<div class="form-group has-success">
		<label class="form-label mt-4" for="pw">새 비밀번호 확인(*)</label>
		<input type="password" class="form-control is-valid" name="pwCh" id="pwCh">
		<div class="valid-feedback"></div>
	</div>
	<br>
	<button class="w-100 btn btn-lg btn-primary" type="submit">변경하기</button>
</form>
</div>
</body>

<script>
let msg1 = "${MSG1}";
let msg2 = "${MSG2}";
if(msg1 != ""){
	alert(msg1);
	self.close();
}else if(msg2 != ""){
	alert(msg2);
}
</script>
</html>