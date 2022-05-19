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
<h3 class="container px-4 py-4 pb-2">회원탈퇴</h3>
<form action="/deleteUserPro" method="post" neme="removefrm" id="deleteForm">
	<div class="form-group has-success">
		<label class="form-label mt-4" for="pw">비밀번호확인</label>
		<input type="password" class="form-control is-valid" name="pw" id="pw">
		<div class="valid-feedback"></div>
	</div>
	<br>
	<button type="button" class="w-100 btn btn-lg btn-primary" onclick="removeCheck()">탈퇴하기</button>
</form>
</div>
</body>

<script>
function removeCheck(){
	if(confirm("탈퇴하시겠습니까?")){
		document.getElementById('deleteForm').submit();
	}
}
let msg1 = "${MSG1}";
let msg2 = "${MSG2}";
if(msg1 != ""){
	alert(msg1);
	opener.location.replace("/");
    window.close();
	//self.close();
}else if(msg2 != ""){
	alert(msg2);
}
</script>
</html>