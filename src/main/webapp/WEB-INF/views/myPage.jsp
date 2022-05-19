<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 class="container px-4 py-4 pb-2">마이페이지</h2>
<section class="bg-light">
	<form action="/userUpdate" name="inputForm" method="post">
		<table class="table table-striped">
			<tbody>
				<tr>
					<th scope="row">ID</th>
					<td>${loginUser.id }</td>
				</tr>
				<tr>
					<th scope="row">Password</th>
					<td>
						<input type="button" value="비밀번호변경" onclick="pwChange()">
					</td>
				</tr>
				<tr>
					<th scope="row">이름</th>
					<td>${loginUser.name }</td>
				</tr>
				<tr>
					<th scope="row">주소</th>
					<td>
						<button class="post_btn" type="button" onclick="addrfuncion()" id='address_kakao'>우편번호 검색</button>
						<input type="text" class="form-control"  onclick="addrfuncion()" id="preAddr" value="${loginUser.preAddr }" placeholder="${loginUser.preAddr }" name="preAddr">
						<input type="text" class="form-control"  id="sufAddr" placeholder="${loginUser.sufAddr }" name="sufAddr">
					</td>
				</tr>
				<tr>
					<th scope="row">생년월일</th>
					<td>${loginUser.birthday }</td>
				</tr>
				<tr>
					<th scope="row">성별</th>
					<td>${loginUser.gender }</td>
				</tr>
				<tr>
					<th scope="row">비밀번호 확인</th>
					<td><input type="password" id="pw" name="pw" placeholder="Password"></td>
				</tr>
			</tbody>
		</table> 
		<div style='width:80px;float: right;'>
			<button type="button" onclick="deleteUser()" >회원탈퇴</button>
		</div>
		<br> <hr>
		<button class="w-100 btn btn-lg btn-primary bg-dark" type="submit">정보수정하기</button>
	</form>
</section>

<script>
// 다음 주소 api
/* function addrfuncion(){
	new daum.Postcode({
		onclose: function(state) {
			if(state === 'FORCE_CLOSE'){
	            //사용자가 브라우저 닫기 버튼을 통해 팝업창을 닫았을 경우, 실행될 코드를 작성하는 부분입니다.
				document.getElementById('preAddr').value = "${loginUser.preAddr}";
				document.getElementById('sufAddr').value = "${loginUser.sufAddr}";
	        } else if(state === 'COMPLETE_CLOSE'){
	     			document.getElementById('preAddr').value = data.roadAddress; 
	     			document.getElementById('sufAddr').value = ""; 
	     			document.getElementById('sufAddr').focus();
	        }
		}
	}).open()
}  */
function addrfuncion(){
	new daum.Postcode({
		oncomplete: function(data) {
			document.getElementById('preAddr').value = data.roadAddress; 
			document.getElementById('sufAddr').value = ""; 
			document.getElementById('sufAddr').focus();
		}
	}).open()
}
function pwChange(){
	var url = "pwChange"
	open(url, "pwChange",  "toolbar=no, location=no, status=no, menubar=no, scrollbars=no resizeable=no, width=400, height=400");
}
function deleteUser(){
	var url = "deleteUser"
	open(url, "deleteUser",  "toolbar=no, location=no, status=no, menubar=no, scrollbars=no resizeable=no, width=450, height=300");
}
</script>