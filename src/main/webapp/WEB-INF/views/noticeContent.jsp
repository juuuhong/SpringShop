<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2 class="container px-4 py-4 pb-2"></h2>
<table class="table">
	<tbody>
		<tr>
			<th scope="row">제목</th>
			<td colspan="4">${notice.title}</td>
		</tr>
		<tr>
			<th scope="row">내용</th>
			<td colspan="4">${notice.content}</td>
		</tr>
		<tr>
			<th scope="row">작성자</th>
			<td >${notice.userId}</td>
			<td class="date">
				<fmt:parseDate value="${notice.createAt}" var="dateValue" pattern="yyyyMMddHHmmss"/>
				<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm"/>
			</td>
			<th scope="row">조회수</th>
			<td>${notice.readcount}</td>
		</tr>
	</tbody>
</table>
<div style='float: right;'>
	<button type="button" class="btn btn-primary" onclick="location.href='/noticeModify?num=${notice.num}'">수정</button>
	<button type="button" class="btn btn-danger" id="noticeDelete" onclick="location.href='/noticeDelete?num=${notice.num}'">삭제</button>
	<button type="button" class="btn btn-primary" onclick="location.href='/notice' ">뒤로</button>
</div>
<br>