<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2 class="container px-4 py-4 pb-2">Please sign in</h2>
<main class="form-signin bg-light">
	<form action="/loginPro" method="post">
		<div class="form-group">
			<label for="id" class="form-label mt-4">ID</label> 
			<input type="text" class="form-control" id="id" name="id" placeholder="ID">
			<div class="chexk_font" id="id_check"></div>
		</div>
		<div class="form-group">
			<label for="id" class="form-label mt-4">Password</label> 
			<input type="password" class="form-control" id="pw" name="pw" placeholder="Password">
			<div class="chexk_font" id="id_check"></div>
		</div>
	
		<!-- <div class="checkbox mb-3">
			<label>
				<input type="checkbox" value="1" id="rememberMe" name="remamberMe"> Remember me
			</label>
		</div> -->
		<br>
		<button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
		<hr>
		<button class="w-100 btn btn-lg btn-primary" type="button" onClick="location.href='http://localhost:8080/signUp'">회원가입</button>
	</form>
</main>