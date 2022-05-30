<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2 class="container px-4 py-4 pb-2">갤러리</h2>
<table class="table">
	<tbody>
		<tr>
			<th scope="row">제목</th>
			<td colspan="4">${gallery.title}</td>
		</tr>
		<tr>
			<th scope="row" >내용</th>
			<td colspan="4">
				<c:if test="${gallery.saved_file_name != null}">
					<img src="/resources/file/${gallery.saved_file_name}"/>
				</c:if>
				${gallery.content}
			</td>
		</tr>
		<tr>
			<th scope="row">작성자</th>
			<td >${gallery.userId}</td>
			<td class="date">
				${gallery.createAt}
			</td>
			<th scope="row">조회수</th>
			<td>${gallery.readcount}</td>
		</tr>
	</tbody>
</table>
<div style='float: right;'>
		<c:if test="${loginUser.id eq gallery.userId }">
			<button type="button" class="btn btn-primary" onclick="location.href='/noticeModify?num=${gallery.num}'">수정</button>
			<button type="button" class="btn btn-danger" id="galleryDelete" onclick="removeCheck()">삭제</button>
		</c:if>
	<button type="button" class="btn btn-primary" onclick="location.href='/gallery' ">목록</button>
</div>
<br>
<script>
function removeCheck(){
	if(confirm("삭제하시겠습니까?")){
		location.href='/galleryDelete?num=${gallery.num}';
	}
}
</script>