<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2 class="container px-4 py-4 pb-2">회원가입</h2>
<section class="bg-light_signUp">
	<form action="/signUpPro" method="post">
	<!--form 태그안에 나중에 추가 method="post" onsubmit="return check() -->
		<div class="form-group">
			<label for="id" class="form-label mt-4">아이디(*)</label> 
			<input type="text" class="form-control" id="id" name="id" autofocus>
			<div class="chexk_font" id="id_check"></div>
		</div>
		<div class="form-group has-success">
			<label class="form-label mt-4" for="pw">비밀번호(*)</label>
			<input type="password" class="form-control is-valid" name="pw" id="pw">
			<div class="valid-feedback"></div>
		</div>
		<div class="form-group has-danger">
			<label class="form-label mt-4" for="pwch">비밀번호 재확인(*)</label> 
			<input type="password" class="form-control is-invalid" id="pwch">
			<div class="invalid-feedback">비밀번호가 일치하지 않습니다</div>
		</div>
		<div class="form-group">
			<label for="name" class="form-label mt-4">이름(*)</label> 
			<input type="text" class="form-control" id="name" name="name">
		</div>
		
		<!-- 다음 주소 api -->
		<div class="form-group">
			<label for="addr" class="form-label" >주소(*)</label> 
			<button class="post_btn" type="button" onclick="addrfuncion()" id='address_kakao'>우편번호 검색</button>
			<input type="text" class="form-control"  onclick="addrfuncion()" id="addr" placeholder="기본주소" name="preAddr">
			<input type="text" class="form-control"  id="addr2" placeholder="나머지 주소" name="sufAddr">
		</div>
		
		<div class="bir_wrap">
			<label class="form-label mt-4">생년월일(*)</label>
			<input type="text" id="selectedDate" class="form-control" value="" placeholder="YYYYMMDD" name="birthday">
			
		</div>
		<div class="form-group">
			<label for="gender" class="form-label mt-4">성별(*)</label> 
			<select class="form-select" id="gender" name="gender">
				<option>남자</option>
				<option>여자</option>
			</select>
		</div>
		<button class="w-100 btn btn-lg btn-primary" type="submit">가입하기</button>
	</form>
</section>
<script>
// 아이디, 비번, 비번체크, 이름, 주소, 생년월일, 성별 작성했는지 확인
	

//캘린더 시작
$(document).ready(function(){
	

});

// 다음 주소 api
function addrfuncion(){
	new daum.Postcode({
		oncomplete: function(data) {
		document.getElementById('addr').value = data.roadAddress; 
	}
	}).open()
	/*document.getElementById('mi_detailAddr').focus(); */
 }
</script>
