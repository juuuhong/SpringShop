<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2 class="container px-4 py-4 pb-2">공지사항</h2>
<c:choose>
	<c:when test="${notices eq [] }">
		<h4 align="center">공지사항이 없습니다.</h4>
	</c:when>
	<c:otherwise>
	<div>
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
		</div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item disabled">
					<a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
				</li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item">
					<a class="page-link" href="#">Next</a>
				</li>
			</ul>
		</nav>
	</c:otherwise>
</c:choose>

<div style='width:80px;float: right;'>
	<button type="button" class="btn btn-primary bg-dark" onclick="location.href='/noticeWrite'">글작성</button>
</div>
<br >