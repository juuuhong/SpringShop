<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2 class="container px-4 py-4 pb-2">공지사항</h2>
<table class="table table-hover">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">제목</th>
			<th scope="col">작성자</th>
			<th scope="col">날짜</th>
			<th scope="col">조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${notices }" var="notices">
			<tr>
				<th scope="row">
					${notices.num }
					<c:set var="num" value="${num - 1}" />
				</th>
				<td>
					<a class="notices" href='/noticeContent?num=${notices.num}'>
					<c:out value="${notices.title}" />
					</a>
				</td>
				<td><c:out value="${notices.userId}"/></td>
				<td>
					<fmt:parseDate value="${notices.createAt}" var="dateValue" pattern="yyyyMMddHHmmss"/>
					<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd"/>
				</td>
				<td><c:out value="${notices.readcount}"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div style='width:80px;float: right;'>
	<button type="button" class="btn btn-primary bg-dark" onclick="location.href='/noticeWrite'">글작성</button>
</div>
<br >