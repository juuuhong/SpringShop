<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 class="container px-4 py-4 pb-2">마이페이지</h2>
<section class="bg-light">
	<form action="/userUpdate" method="post">
		<table class="table table-striped">
			<tbody>
				<tr>
					<th scope="row">ID</th>
					<td>${loginUser.id }</td>
				</tr>
				<tr>
					<th scope="row">Password</th>
					<td>
						<input type="button" value="비밀번호변경">
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
						<input type="text" class="form-control"  onclick="addrfuncion()" id="addr" placeholder="${loginUser.preAddr }" name="preAddr">
						<input type="text" class="form-control"  id="addr2" placeholder="${loginUser.sufAddr }" name="sufAddr">
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
			</tbody>
		</table> 
		<button class="w-100 btn btn-lg btn-primary bg-dark" type="submit">정보수정하기</button>
	</form>
</section>

<script>
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